package ValiIT.back_praktikale_23.domain.address.internshipaddress;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipAddressService {
    @Resource
    private InternshipAddressRepository internshipAddressRepository;

    public List<InternshipAddress> getActiveInternshipsBy(Integer regionId, Integer categoryId) {
        List<InternshipAddress> internshipAddresses = internshipAddressRepository.findInternshipAddressesBy(regionId, categoryId, "A");
        return internshipAddresses;
    }
}
