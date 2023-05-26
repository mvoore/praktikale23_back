package ValiIT.back_praktikale_23.domain.address.address;

import ValiIT.back_praktikale_23.business.address.dto.AddressDto;
import ValiIT.back_praktikale_23.business.address.dto.AddressRequest;
import ValiIT.back_praktikale_23.business.category.CategoryDto;
import ValiIT.back_praktikale_23.domain.internship.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {


    @Mapping(source = "addressName", target = "name")

//    @Mapping(source = "companyId", target = "company.id")
//    @Mapping(source = "regionId", target = "region.id")
//    @Mapping(source = "cityId", target = "city.id")
    Address toAddress(AddressRequest addressRequest);


    @Mapping(source = "id", target = "addressId")
    @Mapping(source = "region.id", target = "regionName")
    @Mapping(source = "city.id", target = "cityName")
    @Mapping(source = "company.id", target = "companyName")
    AddressDto toDto(Address address);

    List<AddressDto> toDtos(List<Address> addresses);

}