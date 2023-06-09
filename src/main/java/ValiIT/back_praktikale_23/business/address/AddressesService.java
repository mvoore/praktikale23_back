package ValiIT.back_praktikale_23.business.address;

import ValiIT.back_praktikale_23.business.address.dto.AddressDto;
import ValiIT.back_praktikale_23.business.address.dto.AddressRequest;
import ValiIT.back_praktikale_23.business.address.dto.CompanyAddressesDto;
import ValiIT.back_praktikale_23.domain.address.Address;
import ValiIT.back_praktikale_23.domain.address.AddressMapper;
import ValiIT.back_praktikale_23.domain.address.AddressService;
import ValiIT.back_praktikale_23.domain.address.city.City;
import ValiIT.back_praktikale_23.domain.address.city.CityService;
import ValiIT.back_praktikale_23.domain.address.region.Region;
import ValiIT.back_praktikale_23.domain.address.region.RegionService;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressesService {
    @Resource
    private AddressService addressService;
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private CompanyService companyService;
    @Resource
    private RegionService regionService;
    @Resource
    private CityService cityService;

    public void addNewAddress(AddressRequest addressRequest) {
        Address address = addressMapper.toAddress(addressRequest);
        Company company = companyService.findCompanyBy(addressRequest.getUserId());
        address.setCompany(company);
        Region region = regionService.findRegionBy(addressRequest.getRegionId());
        address.setRegion(region);
        City city = cityService.findCityBy(addressRequest.getCityId());
        address.setCity(city);
        addressService.addAddress(address);
    }

    public List<AddressDto> getCompanyAddress(Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        List<Address> addresses = addressService.getCompanyAddressBy(company.getId());
        List<AddressDto> addressesDto = addressMapper.toAddressesDto(addresses);
        return addressesDto;
    }


    public List<CompanyAddressesDto> getCompanyAddresses(Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        List<Address> companyAddresses = addressService.getCompanyAddressesBy(company.getId());
        List<CompanyAddressesDto> dtos = addressMapper.toDtos(companyAddresses);
        return dtos;
    }
}