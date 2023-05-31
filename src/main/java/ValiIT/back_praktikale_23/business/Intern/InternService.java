package ValiIT.back_praktikale_23.business.Intern;
import ValiIT.back_praktikale_23.domain.user.coverletter.Coverletter;
import ValiIT.back_praktikale_23.domain.user.coverletter.CoverletterMapper;
import ValiIT.back_praktikale_23.domain.user.coverletter.CoverletterService;
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

    @Resource
    private CoverletterService coverletterService;

    @Resource
    private CoverletterMapper coverletterMapper;


    public void addCvToIntern(Integer userId, CvRequest cvRequest) {
        Cv cv = cvMapper.toEntity(cvRequest);
        cvService.setUserId(userId);
        cvService.addCv(cv);

    }

    public void addCoverletterToIntern(Integer userId, CoverletterRequest coverletterRequest) {
        Coverletter coverletter = coverletterMapper.toEntity(coverletterRequest);
        coverletterService.setUserId(userId);
        coverletterService.addCoverletter(coverletter);
    }
}
