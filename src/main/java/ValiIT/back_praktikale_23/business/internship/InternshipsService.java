package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.business.internship.dto.InternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipRequest;
import ValiIT.back_praktikale_23.domain.address.Address;
import ValiIT.back_praktikale_23.domain.address.AddressService;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressMapper;
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
        byte[] data = ImageUtil.base64ImageDataToByteArray(imageData);
        image.setData(data);
        imageService.addImage(image);
        internship.setImage(image);
    }

    private void setCompany(Internship internship, Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        internship.setCompany(company);
    }

}
