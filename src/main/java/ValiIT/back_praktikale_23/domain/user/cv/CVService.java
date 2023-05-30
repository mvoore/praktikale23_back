package ValiIT.back_praktikale_23.domain.user.cv;

import ValiIT.back_praktikale_23.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CVService {
    @Resource
    private CvRepository cvRepository;
    private Integer userId;

    public void addCv(Cv cv) {
        User user = new User();
        user.setId(userId);
        cv.setUser(user);
        cvRepository.save(cv);
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
