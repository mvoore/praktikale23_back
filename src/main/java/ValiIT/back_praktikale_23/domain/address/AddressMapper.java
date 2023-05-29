package ValiIT.back_praktikale_23.domain.address;

import ValiIT.back_praktikale_23.business.address.dto.AddressDto;
import ValiIT.back_praktikale_23.business.address.dto.AddressRequest;
import ValiIT.back_praktikale_23.business.address.dto.CompanyAddressesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    @Mapping(source = "addressName", target = "name")
    @Mapping(constant = "A", target = "status")
    Address toAddress(AddressRequest addressRequest);

    @Mapping(source = "id", target = "addressId")
    @Mapping(source = "name", target = "addressName")
    AddressDto toAddressDto(Address address);

    @Mapping(source = "id", target = "addressId")
    @Mapping(source = "region.name", target = "regionName")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "streetNumber", target = "streetNumber")
    CompanyAddressesDto toDto(Address address);


    List<AddressDto> toAddressesDto(List<Address> addresses);


    List<CompanyAddressesDto> toDtos(List<Address> companyAddresses);
}