package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationDto;
import ValiIT.back_praktikale_23.business.Intern.dto.ApplicationRequest;
import ValiIT.back_praktikale_23.business.user.dto.UserDto;
import ValiIT.back_praktikale_23.business.user.dto.UserEdit;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/intern")
public class InternController {
    @Resource
    private InternService internService;


    @GetMapping
    @Operation(summary = "Leiab andmebaasist (user tabelist) interni info.")
    public UserDto getInternInfo(@RequestParam Integer userId) {
        UserDto internInfo = internService.getInternInfo(userId);
        return internInfo;
    }

    @PatchMapping()
    @Operation(summary = "Uuendab interni andmeid.")
    public UserDto updateInternInfo(@RequestParam Integer userId, @RequestBody UserEdit userEdit) {
        internService.updateInternInfo(userId, userEdit);
        return null;

    }

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
    @Operation(summary = "Võtab sisse InternshipId ja salvestab applicationi andmebaasi uue kirjena")
    public void addApplication(@RequestBody ApplicationRequest applicationRequest) {
        internService.addApplication(applicationRequest);
    }

    @GetMapping("/applications")
    @Operation(summary = "otsib userId alusel konkreetsed praktika avaldused")
    public List<ApplicationDto> getApplications(@RequestParam Integer userId) {
        List<ApplicationDto> applications = internService.getApplications(userId);
        return applications;
    }





}
