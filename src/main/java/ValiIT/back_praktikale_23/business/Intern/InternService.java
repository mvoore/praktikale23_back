package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationDto;
import ValiIT.back_praktikale_23.domain.internship.Internship;
import ValiIT.back_praktikale_23.domain.internship.InternshipService;
import ValiIT.back_praktikale_23.domain.internship.application.Application;
import ValiIT.back_praktikale_23.domain.internship.application.ApplicationMapper;
import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationRequest;
import ValiIT.back_praktikale_23.domain.internship.application.ApplicationService;
import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.UserService;
import ValiIT.back_praktikale_23.domain.user.coverletter.Coverletter;
import ValiIT.back_praktikale_23.domain.user.coverletter.CoverletterMapper;
import ValiIT.back_praktikale_23.domain.user.coverletter.CoverletterService;
import ValiIT.back_praktikale_23.domain.user.cv.CVService;
import ValiIT.back_praktikale_23.domain.user.cv.Cv;
import ValiIT.back_praktikale_23.domain.user.cv.CvMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Resource
    private ApplicationMapper applicationMapper;

    @Resource
    private ApplicationService applicationService;

    @Resource
    private InternshipService internshipService;

    @Resource
    private UserService userService;


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

    public void addApplication(ApplicationRequest applicationRequest) {
        Application application = applicationMapper.toEntity(applicationRequest);
        Internship internship = internshipService.getInternshipBy(applicationRequest.getInternshipId());
        application.setInternship(internship);
        User user = userService.getUserBy(applicationRequest.getUserId());
        application.setUser(user);
        applicationService.addApplication(application);
    }



}
