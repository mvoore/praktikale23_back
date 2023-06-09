package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.business.Status;
import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipOffer;
import ValiIT.back_praktikale_23.domain.address.Address;
import ValiIT.back_praktikale_23.domain.address.AddressService;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressMapper;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressService;
import ValiIT.back_praktikale_23.domain.internship.Internship;
import ValiIT.back_praktikale_23.domain.internship.InternshipDetailToApplication;
import ValiIT.back_praktikale_23.domain.internship.InternshipMapper;
import ValiIT.back_praktikale_23.domain.internship.InternshipService;
import ValiIT.back_praktikale_23.domain.internship.category.Category;
import ValiIT.back_praktikale_23.domain.internship.category.CategoryService;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyService;
import ValiIT.back_praktikale_23.domain.internship.image.Image;
import ValiIT.back_praktikale_23.domain.internship.image.ImageService;
import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.UserService;
import ValiIT.back_praktikale_23.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private UserService userService;

    @Resource
    private InternshipAddressMapper internshipAddressMapper;

    @Resource
    private InternshipMapper internshipMapper;

    @Resource
    private AddressService addressService;


    public List<InternshipDto> getInternships(Integer sortValue, Integer regionId, Integer categoryId) {
        List<InternshipAddress> activeInternshipAddresses = internshipAddressService.getActiveInternshipsBy(sortValue, regionId, categoryId);
        List<InternshipDto> dtos = internshipAddressMapper.toDtos(activeInternshipAddresses);
        return dtos;
    }

    @Transactional
    public void addInternship(InternshipOffer request) {
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
        byte[] data = ImageUtil.base64ImageDataToByteArray(imageData);
        image.setData(data);
        imageService.addImage(image);
        internship.setImage(image);
    }

    private void setCompany(Internship internship, Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        internship.setCompany(company);
    }

    @Transactional
    public void editInternship(Integer internshipId, InternshipOffer request) {
        Internship internship = internshipService.getInternshipBy(internshipId);
        internshipMapper.partialUpdate(request, internship);
        setCompany(internship, request.getUserId());
        setCategory(internship, request.getCategoryId());
        InternshipAddress internshipAddress = internshipAddressService.findInternshipAddressBy(internshipId);
        Address address = addressService.findAddressBy(request.getAddressId());
        internshipAddress.setAddress(address);
        internshipAddressService.addInternshipAddress(internshipAddress);
        handleImageChange(internship, request);
        internshipService.addInternship(internship);

    }

    private void handleImageChange(Internship internship, InternshipOffer request) {
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

    public List<CompanyInternshipDto> getActiveInternships(Integer userId) {
        User user = userService.getUserBy(userId);
        List<InternshipAddress> companyActiveInternships = internshipAddressService.getCompanyInternshipsBy(user, Status.ACTIVE);
        List<CompanyInternshipDto> activeInternshipDtos = internshipMapper.toDtos(companyActiveInternships);
        return activeInternshipDtos;
    }

    public List<CompanyInternshipDto> getInactiveInternships(Integer userId) {
        User user = userService.getUserBy(userId);
        List<InternshipAddress> companyInactiveInternships = internshipAddressService.getCompanyInternshipsBy(user, Status.DELETED);
        List<CompanyInternshipDto> inactiveInternshipDtos = internshipMapper.toDtos(companyInactiveInternships);
        return inactiveInternshipDtos;
    }

    public InternshipOffer getInternshipOffer(Integer internshipId) {
        Internship internship = internshipService.getInternshipBy(internshipId);
        InternshipOffer offer =internshipMapper.toInternshipOffer(internship);
        InternshipAddress internshipAddress = internshipAddressService.findInternshipAddressBy(internshipId);
        offer.setAddressId(internshipAddress.getAddress().getId());
        return offer;
    }

    public InternshipDetailToApplication getInternshipDetailsToApplication(Integer internshipId) {
        Internship internship = internshipService.getInternshipBy(internshipId);
        InternshipDetailToApplication internshipDetailToApplication = internshipMapper.internshipDetailToApplication(internship);
        return internshipDetailToApplication;
    }
    public void deactivateInternship(Integer internshipId) {
        internshipService.deactivateInternship(internshipId);
    }

    public void activateInternship(Integer internshipId) {
        internshipService.activateInternship(internshipId);
    }
}
