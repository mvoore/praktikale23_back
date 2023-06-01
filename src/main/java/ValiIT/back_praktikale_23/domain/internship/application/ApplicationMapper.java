package ValiIT.back_praktikale_23.domain.internship.application;

import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationDto;
import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationRequest;
import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "internshipId", target = "internship.id")
    @Mapping(constant = "A", target = "status")
    Application toEntity(ApplicationRequest applicationRequest);


}