package ValiIT.back_praktikale_23.domain.user.coverletter;

import ValiIT.back_praktikale_23.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CoverletterService {

    @Resource
    private CoverletterRepository coverletterRepository;

    private Integer userId;

    public void addCoverletter(Coverletter coverletter){
        User user = new User();
        user.setId(userId);
        coverletter.setUser(user);
        coverletterRepository.save(coverletter);
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
}
