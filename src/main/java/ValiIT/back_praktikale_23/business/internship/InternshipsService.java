package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.business.internship.dto.InternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipRequest;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressMapper;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressService;
import ValiIT.back_praktikale_23.domain.internship.Internship;
import ValiIT.back_praktikale_23.domain.internship.InternshipMapper;
import ValiIT.back_praktikale_23.domain.internship.InternshipService;
import ValiIT.back_praktikale_23.domain.internship.category.Category;
import ValiIT.back_praktikale_23.domain.internship.category.CategoryService;
import ValiIT.back_praktikale_23.domain.internship.image.Image;
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
    private InternshipAddressMapper internshipAddressMapper;

    @Resource
    private InternshipService internshipService;

    @Resource
    private InternshipMapper internshipMapper;

    @Resource
    private CategoryService categoryService;


    public List<InternshipDto> getInternships(Integer sortValue, Integer regionId, Integer categoryId) {
        List<InternshipAddress> activeInternshipAddresses = internshipAddressService.getActiveInternshipsBy(sortValue, regionId, categoryId);
        List<InternshipDto> dtos = internshipAddressMapper.toDtos(activeInternshipAddresses);
        return dtos;
    }

    @Transactional
    public void addInternship(InternshipRequest internshipRequest) {
        Internship internship = internshipMapper.toEntity(internshipRequest);
        Integer categoryId = internshipRequest.getCategoryId();
        Category category = categoryService.findCategoryBy(categoryId);
        internship.setCategory(category);

        Image image = new Image();
        String imageData = internshipRequest.getImageData();
        byte[] data = ImageUtil.base64ImageDataToByteArray(imageData);
        image.setData(data);

//
//        @Mapping(source = "", target = "image")
//
//
//        @Mapping(source = "", target = "company")



    }
}
