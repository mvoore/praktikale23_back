package ValiIT.back_praktikale_23.domain.internship;

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
}
