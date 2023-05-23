package ValiIT.back_praktikale_23.domain.address.internshipaddress;

import ValiIT.back_praktikale_23.business.internship.InternshipDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InternshipAddressMapper {

    @Mapping(source = "", target = "internshipId")
    @Mapping(source = "", target = "title")
    @Mapping(source = "", target = "companyName")
    @Mapping(source = "", target = "categoryName")
    @Mapping(source = "", target = "regionName")
    @Mapping(source = "", target = "imageData")
    @Mapping(source = "", target = "dateAdded")
    InternshipDto toDto(InternshipAddress internshipAddress);

   List <InternshipDto> toDtos(List <InternshipAddress> internshipAddresses);

}