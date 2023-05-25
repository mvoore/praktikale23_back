package ValiIT.back_praktikale_23.domain.address;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Resource
    private AddressRepository addressRepository;



    public Address findAddressBy(Integer addressId) {
        Address address = addressRepository.findAddressBy(addressId);
        return address;
    }
}
