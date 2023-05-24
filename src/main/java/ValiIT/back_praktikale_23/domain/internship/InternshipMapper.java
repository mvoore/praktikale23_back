package ValiIT.back_praktikale_23.domain.internship;

import ValiIT.back_praktikale_23.business.internship.dto.InternshipRequest;
import org.mapstruct.*;

import java.time.LocalDate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDate.class})
public interface InternshipMapper {
    @Mapping(constant = "A", target = "status")
    @Mapping(expression = "java(LocalDate.now())", target = "dateAdded")
    Internship toEntity(InternshipRequest internshipDto);
}