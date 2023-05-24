package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddress;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressMapper;
import ValiIT.back_praktikale_23.domain.address.internshipaddress.InternshipAddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipsService {

    @Resource
    private InternshipAddressService internshipAddressService;

    @Resource
    private InternshipAddressMapper internshipAddressMapper;


    public List<InternshipDto> getInternships(Integer sortValue, Integer regionId, Integer categoryId) {
        List<InternshipAddress> activeInternshipAddresses = internshipAddressService.getActiveInternshipsBy(sortValue, regionId, categoryId);
        List<InternshipDto> dtos = internshipAddressMapper.toDtos(activeInternshipAddresses);
        return dtos;
    }
}

