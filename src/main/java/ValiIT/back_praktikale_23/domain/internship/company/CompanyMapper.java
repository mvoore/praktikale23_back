package ValiIT.back_praktikale_23.domain.internship.company;

import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyDto;
import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyModifyRequest;
import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {

    @Mapping(source = "name", target = "companyName")
    CompanyDto toDto(Company company);

    @Mapping(source = "companyName", target = "name")
    Company toEntity(CompanyRequest companyRequest);

    @Mapping(source = "companyName", target = "name")
    Company partialUpdate(CompanyModifyRequest request, @MappingTarget Company company);
}