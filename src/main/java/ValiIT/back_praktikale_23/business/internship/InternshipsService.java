package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressMapper;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressService;
import ValiIT.back_praktikale_23.domain.internship.Internship;
import ValiIT.back_praktikale_23.domain.internship.InternshipMapper;
import ValiIT.back_praktikale_23.domain.internship.InternshipService;
import ValiIT.back_praktikale_23.domain.internship.category.Category;
import ValiIT.back_praktikale_23.domain.internship.category.CategoryService;
import jakarta.annotation.Resource;
import org.mapstruct.Mapping;
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
    public void addInternship(InternshipDto internshipDto) {
//        Internship internship = internshipMapper.toEntity(internshipDto);
//        Integer categoryId = internshipDto.getCategoryId();
//        Category category = categoryService.findCategoryBy(categoryId);
//        internship.setCategory(category);


//        @Mapping(source = "", target = "image")


//        @Mapping(source = "", target = "company")



    }
}
