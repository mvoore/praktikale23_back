package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipRequest;
import ValiIT.back_praktikale_23.domain.address.Address;
import ValiIT.back_praktikale_23.domain.address.AddressService;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressMapper;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressRepository;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressService;
import ValiIT.back_praktikale_23.domain.internship.Internship;
import ValiIT.back_praktikale_23.domain.internship.InternshipMapper;
import ValiIT.back_praktikale_23.domain.internship.InternshipService;
import ValiIT.back_praktikale_23.domain.internship.category.Category;
import ValiIT.back_praktikale_23.domain.internship.category.CategoryService;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyService;
import ValiIT.back_praktikale_23.domain.internship.image.Image;
import ValiIT.back_praktikale_23.domain.internship.image.ImageService;
import ValiIT.back_praktikale_23.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static ValiIT.back_praktikale_23.util.ImageUtil.base64ImageDataToByteArray;

@Service
public class InternshipsService {

    @Resource
    private InternshipAddressService internshipAddressService;

    @Resource
    private ImageService imageService;

    @Resource
    private InternshipService internshipService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CompanyService companyService;

    @Resource
    private InternshipAddressMapper internshipAddressMapper;

    @Resource
    private InternshipMapper internshipMapper;

    @Resource
    private AddressService addressService;
    private final InternshipAddressRepository internshipAddressRepository;

    public InternshipsService(InternshipAddressRepository internshipAddressRepository) {
        this.internshipAddressRepository = internshipAddressRepository;
    }


    public List<InternshipDto> getInternships(Integer sortValue, Integer regionId, Integer categoryId) {
        List<InternshipAddress> activeInternshipAddresses = internshipAddressService.getActiveInternshipsBy(sortValue, regionId, categoryId);
        List<InternshipDto> dtos = internshipAddressMapper.toDtos(activeInternshipAddresses);
        return dtos;
    }

    @Transactional
    public void addInternship(InternshipRequest request) {
        Internship internship = internshipMapper.toEntity(request);
        setCategory(internship, request.getCategoryId());
        setImage(internship, request.getImageData());
        setCompany(internship, request.getUserId());
        internshipService.addInternship(internship);
        addInternshipAddress(internship, request.getAddressId());
    }

    private void addInternshipAddress(Internship internship, Integer addressId) {
        //TODO address id abil leida üles address objekt/rida
        //TODO luua uus objekt internshipAddress, panna sinna külge objektid address ja internship
        //TODO salvesta internshipAddress admebaasi
        Address address = addressService.findAddressBy(addressId);
        InternshipAddress internshipAddress = new InternshipAddress();
        internshipAddress.setAddress(address);
        internshipAddress.setInternship(internship);
        internshipAddressService.addInternshipAddress(internshipAddress);
    }

    private void setCategory(Internship internship, Integer categoryId) {
        Category category = categoryService.findCategoryBy(categoryId);
        internship.setCategory(category);
    }

    private void setImage(Internship internship, String imageData) {
        Image image = new Image();
        byte[] data = base64ImageDataToByteArray(imageData);
        image.setData(data);
        imageService.addImage(image);
        internship.setImage(image);
    }

    private void setCompany(Internship internship, Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        internship.setCompany(company);
    }

    @Transactional
    public void editInternship(Integer internshipId, InternshipRequest request) {
        Internship internship = internshipService.getInternshipBy(internshipId);
        internshipMapper.partialUpdate(request, internship);
        setCompany(internship, request.getUserId());
        setCategory(internship, request.getCategoryId());
        InternshipAddress internshipAddress = internshipAddressService.findInternshipAddressById(internshipId);
        Address address = addressService.findAddressBy(request.getAddressId());
        internshipAddress.setAddress(address);
        internshipAddressService.addInternshipAddress(internshipAddress);
        handleImageChange(internship, request);
        internshipService.addInternship(internship);


        // TODO: InternshipId abil leida üles internshipAddress (objekt/rida).
        // TODO: addressId abil leida üles address (objekt/rida). Setteriga panna see internshipAddress külge
        //  ja salvestame InternshipAddress tabelisse.


        // TODO: internshipi küljest vaadata getImage() abil et kas internship objekti küles on pilt
        //  Kui requesti imageData ei ole tühi string siis converdime selle ümber, lisame setteriga Image külge ja salvestame Image tabelisse
        //  Kui internshipi küljes ei ole imaget ja Image data ei ole tühi string siis me teeme uue image objekti, salvestame image tabelisse ära ja paneme image Internshipi külge


    }

    private void handleImageChange(Internship internship, InternshipRequest request) {
        Image currentImage = internship.getImage();

        if (currentImageUpdateIsRequired(currentImage, request.getImageData())) {
            currentImage.setData(ImageUtil.base64ImageDataToByteArray(request.getImageData()));
        }

        if (newImageIsRequired(request.getImageData(), currentImage)) {
            Image image = new Image();
            internship.setImage(image);
            imageService.addImage(image);
        }
    }

    private static boolean currentImageUpdateIsRequired(Image currentImage, String imageDataFromUpdate) {
        return ImageUtil.imageIsPresent(currentImage) && !imageDataFromUpdate.equals(ImageUtil.byteArrayToBase64ImageData(currentImage.getData()));
    }

    private static boolean newImageIsRequired(String imageDataFromUpdate, Image currentImage) {
        return currentImage == null && !imageDataFromUpdate.isEmpty();
    }
    public List<CompanyInternshipDto> getCompanyInternships(Integer userId) {
        List<InternshipAddress> companyActiveInternships = internshipAddressService.getCompanyActiveInternshipsBy(userId);
        List<CompanyInternshipDto> internshipDtos = internshipMapper.toDtos(companyActiveInternships);
        return internshipDtos;
    }
}
