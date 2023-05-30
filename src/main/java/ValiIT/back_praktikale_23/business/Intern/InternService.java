package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.cv.CVService;
import ValiIT.back_praktikale_23.domain.user.cv.Cv;
import ValiIT.back_praktikale_23.domain.user.cv.CvMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    @Resource
    private CVService cvService;

    @Resource
    private CvMapper cvMapper;




    public void addCvToIntern(Integer userId, CvRequest cvRequest) {
        Cv cv = cvMapper.toEntity(cvRequest);
        cvService.setUserId(userId);
        cvService.addCv(cv);

    }
}




//ToDO mappi cvrequest ümber cv objektiks
// peale seda saab CVservicei kaudu salvestada uue rea cv tabelisse

