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
    public void addNewAddress(@RequestBody AddressRequest addressRequest) {
        addressesService.addNewAddress(addressRequest);
    }

    @GetMapping()
    @Operation(summary = "Leiab süsteemist addressName(andmebaasist address tabelist) aadressi", description = "kui addressId=0 leiab kõik aadressid")

    public List<AddressDto> getAddresses(){
        List<AddressDto> addresses=addressesService.getAddresses();
        return addresses;
    }
}
