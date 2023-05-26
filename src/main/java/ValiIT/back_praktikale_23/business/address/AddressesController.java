package ValiIT.back_praktikale_23.business.address;

import ValiIT.back_praktikale_23.business.address.dto.AddressDto;
import ValiIT.back_praktikale_23.business.address.dto.AddressRequest;
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
    @Operation(summary = "Leiab andmebaasist firmaga seotud aadressid")
    public List<AddressDto> findCompanyAddresses(@RequestParam Integer companyId) {
        List<AddressDto> addresses = addressesService.getCompanyAddress(companyId);
        return addresses;

    }


}
