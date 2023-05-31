package ValiIT.back_praktikale_23.domain.internship.application;

import ValiIT.back_praktikale_23.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Resource
    private ApplicationRepository applicationRepository;

    private Integer userId;
    public void addApplication(Application application) {
        User user = new User();
        user.setId(userId);
        application.setUser(user);
        applicationRepository.save(application);
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }
}
