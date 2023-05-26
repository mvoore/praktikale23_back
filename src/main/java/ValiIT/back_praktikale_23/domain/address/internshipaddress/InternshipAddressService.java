package ValiIT.back_praktikale_23.domain.address.internshipaddress;

import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipAddressService {

    @Resource
    private InternshipAddressRepository internshipAddressRepository;

    public List<InternshipAddress> getActiveInternshipsBy(Integer sortValue, Integer regionId, Integer categoryId) {
        Sort sort = getSortFromSortValue(sortValue);
        List<InternshipAddress> internshipAddresses = internshipAddressRepository.findInternshipAddressesBy(regionId, categoryId, "A", sort);
        return internshipAddresses;
    }

    private static Sort getSortFromSortValue(Integer sortValue) {
        return sortValue == 1
                ? Sort.by(Sort.Direction.DESC, "internship.dateAdded")
                : Sort.by(Sort.Direction.ASC, "internship.dateAdded");
    }

    public void addInternshipAddress(InternshipAddress internshipAddress) {
        internshipAddressRepository.save(internshipAddress);
    }
}
