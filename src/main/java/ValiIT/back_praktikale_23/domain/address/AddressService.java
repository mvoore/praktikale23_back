package ValiIT.back_praktikale_23.domain.address;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Resource
    private AddressRepository addressRepository;


    public Address findAddressBy(Integer addressId) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        Address address = optionalAddress.get();
        return address;
    }


    public void addAddress(Address address) {
        addressRepository.save(address);

    }

    public List<Address> getCompanyAddressBy(Integer userId) {
        List<Address> addresses = addressRepository.findAddressesBy(userId);
        return addresses;
    }
}
