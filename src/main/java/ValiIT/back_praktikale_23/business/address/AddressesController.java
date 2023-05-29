package ValiIT.back_praktikale_23.business.address;

import ValiIT.back_praktikale_23.business.address.dto.AddressDto;
import ValiIT.back_praktikale_23.business.address.dto.AddressRequest;
import ValiIT.back_praktikale_23.business.address.dto.CompanyAddressDto;
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
    @GetMapping("/company-address")
    @Operation(summary = "Leiab andmbaasist firmaga seotud aadressid ja tagastab kogu nende info")
    public List<CompanyAddressDto> findAddresses(@RequestParam Integer userId) {
        List<CompanyAddressDto> companyAddresses = addressesService.findCompanyAddresses(userId);
        return companyAddresses;

    }

}
