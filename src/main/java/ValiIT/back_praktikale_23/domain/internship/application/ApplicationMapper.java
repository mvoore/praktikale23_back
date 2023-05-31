package ValiIT.back_praktikale_23.domain.internship.application;

import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "internshipId", target = "internship.id")
    @Mapping(constant = "A", target = "status")
    Application toEntity(ApplicationRequest applicationRequest);



}