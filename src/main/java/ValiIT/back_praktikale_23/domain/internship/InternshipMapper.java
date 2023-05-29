package ValiIT.back_praktikale_23.domain.internship;

import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipRequest;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDate.class})
public interface InternshipMapper {
    @Mapping(constant = "A", target = "status")
    @Mapping(expression = "java(LocalDate.now())", target = "dateAdded")
    Internship toEntity(InternshipRequest internshipDto);

    @Mapping(source = "id", target = "internshipId")
    @Mapping(source = "internship.title", target = "title")
    @Mapping(source = "internship.category.name", target = "categoryName")
    @Mapping(source = "internship.dateAdded", target = "dateAdded")
    CompanyInternshipDto toDto(InternshipAddress internshipAddress);

    List<CompanyInternshipDto> toDtos(List<InternshipAddress> internshipAddresses);
}