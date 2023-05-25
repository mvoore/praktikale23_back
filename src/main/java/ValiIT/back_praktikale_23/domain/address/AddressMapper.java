package ValiIT.back_praktikale_23.domain.address;

import ValiIT.back_praktikale_23.business.address.AddressRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
//    @Mapping(source = "companyId", target = "company")
//    @Mapping(source = "regionId", target = "region")
//    @Mapping(source = "cityId", target = "city")

    @Mapping(source = "addressName", target = "name")
    @Mapping(source = "streetNumber", target = "streetNumber")
    Address toEntity(AddressRequest addressRequest);





}