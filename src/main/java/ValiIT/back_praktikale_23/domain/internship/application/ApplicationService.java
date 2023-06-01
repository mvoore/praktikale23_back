package ValiIT.back_praktikale_23.domain.internship.application;

import ValiIT.back_praktikale_23.domain.internship.Internship;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Resource
    private ApplicationRepository applicationRepository;



    public void addApplication(Application application) {
        applicationRepository.save(application);
    }



}
