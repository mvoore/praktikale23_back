package ValiIT.back_praktikale_23.domain.internship;

import ValiIT.back_praktikale_23.business.internship.InternshipDto;
import ValiIT.back_praktikale_23.domain.internship.image.Image;
import ValiIT.back_praktikale_23.util.ImageUtil;
import org.mapstruct.*;

import java.time.LocalDate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDate.class})
public interface InternshipMapper {



    @Mapping(source = "title", target = "title")
//    @Mapping(source = "description", target = "description")
    @Mapping(constant = "A", target = "status")
    @Mapping(expression = "java(LocalDate.now())", target = "dateAdded")
    Internship toEntity(InternshipDto internshipDto);


}