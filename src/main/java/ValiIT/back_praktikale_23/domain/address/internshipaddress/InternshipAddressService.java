package ValiIT.back_praktikale_23.domain.address.internshipaddress;

import ValiIT.back_praktikale_23.business.Status;
import ValiIT.back_praktikale_23.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public InternshipAddress findInternshipAddressBy(Integer internshipId) {
        Optional<InternshipAddress> optionalInternshipAddress = internshipAddressRepository.findById(internshipId);
        InternshipAddress internshipAddress = optionalInternshipAddress.get();
        return internshipAddress;
    }

    public List<InternshipAddress> getCompanyInternshipsBy(User user, Status status) {
        return internshipAddressRepository.findInternshipAddressesBy(user, status.getLetter());
    }
}
