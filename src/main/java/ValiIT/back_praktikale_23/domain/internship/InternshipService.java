package ValiIT.back_praktikale_23.domain.internship;

import ValiIT.back_praktikale_23.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    @Resource
    private InternshipRepository internshipRepository;

    public List<Internship> getActiveInternshipsBy(Integer regionId, Integer categoryId) {
        List<Internship> internships = internshipRepository.findAll();
        return internships;
    }

    public void addInternship(Internship internship) {
        internshipRepository.save(internship);
    }

    public List<Internship> getCompanyActiveInternshipsBy(Integer userId) {
        List<Internship> companyActiveInternships = internshipRepository.findCompanyActiveInternshipsBy(userId, Status.ACTIVE.getLetter());
        return companyActiveInternships;
    }


    public Internship getInternshipBy(Integer internshipId) {
        return internshipRepository.findById(internshipId).get();

    }
}
