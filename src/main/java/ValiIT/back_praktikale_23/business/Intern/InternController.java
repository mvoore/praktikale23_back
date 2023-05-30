package ValiIT.back_praktikale_23.business.Intern;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/intern")
public class InternController {
    @Resource
    private InternService internService;

    @PostMapping
    @Operation(summary = "Lisab CV andmebaasi.")

    public void addCvToIntern(@RequestParam Integer userId, @RequestBody CvRequest cvRequest){
    internService.addCvToIntern(userId,cvRequest);

    }
}