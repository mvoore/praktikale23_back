package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.domain.internship.Internship;
import ValiIT.back_praktikale_23.domain.internship.InternshipService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/intern")
public class InternController {
    @Resource
    private InternService internService;
    @Resource
    private InternshipService internshipService;

    @PostMapping("/cv")
    @Operation(summary = "Lisab CV andmebaasi.")
    public void addCvToIntern(@RequestParam Integer userId, @RequestBody CvRequest cvRequest) {
        internService.addCvToIntern(userId, cvRequest);

    }

    @PostMapping("/coverletter")
    @Operation(summary = "Lisab coverletteri andmebaasi.")
    public void addCoverletterToIntern(@RequestParam Integer userId, @RequestBody CoverletterRequest coverletterRequest) {
        internService.addCoverletterToIntern(userId, coverletterRequest);
    }


}
