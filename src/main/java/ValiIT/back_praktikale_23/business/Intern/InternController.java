package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/intern")
public class InternController {
    @Resource
    private InternService internService;


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

    @PostMapping("/add-application")
    @Operation(summary = "Salvestab applicationi andmebaasi uue kirjena")
    public void addApplication(@RequestParam Integer userId,@RequestBody ApplicationRequest applicationRequest) {
        internService.addApplication(userId,applicationRequest);
    }


}
