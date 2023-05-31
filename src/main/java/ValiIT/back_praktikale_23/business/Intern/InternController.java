package ValiIT.back_praktikale_23.business.Intern;

import ValiIT.back_praktikale_23.business.user.dto.UserDto;
import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.UserMapper;
import ValiIT.back_praktikale_23.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/intern")
public class InternController {
    @Resource
    private InternService internService;


    @GetMapping
    @Operation(summary = "Leiab andmebaasist (user tabelist) interni fullnamei ja emaili.")
    public UserDto getInternInfo(@RequestParam Integer userId) {
        UserDto internInfo = internService.getInternInfo(userId);
        return internInfo;
    }

//    @PatchMapping()
//    @Operation(summary = "Uuendab interni andmeid.")
//    public UserDto updateInternInfo(@PathVariable Long id, @RequestBody UserDto userDto) {
//        User user = internService.findById(id);
//        return null;
//
//    }

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


