package ValiIT.back_praktikale_23.domain.address;

import ValiIT.back_praktikale_23.business.address.AddressRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    @Mapping(source = "addressName", target = "name")

//    @Mapping(source = "companyId", target = "company.id")
//    @Mapping(source = "regionId", target = "region.id")
//    @Mapping(source = "cityId", target = "city.id")
    Address toEntity(AddressRequest addressRequest);



}