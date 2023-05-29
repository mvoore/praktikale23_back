package ValiIT.back_praktikale_23.business.address;

import ValiIT.back_praktikale_23.business.address.dto.AddressDto;
import ValiIT.back_praktikale_23.business.address.dto.AddressRequest;
import ValiIT.back_praktikale_23.business.address.dto.CompanyAddressesDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressesController {
    @Resource
    private AddressesService addressesService;

    @PostMapping
    @Operation(summary = "Lisab andmebaasi uue aadressi")
    public void addNewAddress(@RequestBody AddressRequest addressRequest) {
        addressesService.addNewAddress(addressRequest);
    }

    @GetMapping
    @Operation(summary = "Leiab andmebaasist firmaga seotud aadressid ja tagastab need aadressile antud nimena")
    public List<AddressDto> findCompanyAddresses(@RequestParam Integer userId) {
        List<AddressDto> addresses = addressesService.getCompanyAddress(userId);
        return addresses;
    }

    @GetMapping("/company-addresses")
    @Operation(summary = "Leiab andmebaasist firmaga seotud aktiivsed aadressid userId abil ja tagastab kogu nendega seotud info")
    public List<CompanyAddressesDto> getCompanyAddresses(@RequestParam Integer userId) {
        List<CompanyAddressesDto> companyAddresses = addressesService.getCompanyAddresses(userId);
        return companyAddresses;
    }
}
