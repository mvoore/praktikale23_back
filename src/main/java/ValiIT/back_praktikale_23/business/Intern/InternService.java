package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.domain.user.cv.CVService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    @Resource
    private CVService cvService;


    public void addCvToIntern(Integer userId, CvRequest cvRequest) {
        cvService.addCvToIntern()

    }
}
