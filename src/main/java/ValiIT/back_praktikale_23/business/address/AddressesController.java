package ValiIT.back_praktikale_23.business.address;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressesController {
    @Resource
    private AddressesService addressesService;

    @PostMapping
    public void addNewAddress(@RequestBody AddressRequest addressRequest) {
        addressesService.addNewAddress(addressRequest);
    }
}
