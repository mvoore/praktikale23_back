package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class InternshipsController {

    @Resource
    private InternshipsService internshipsService;



    @GetMapping("/internships")
    @Operation(summary = "Leiab süsteemist (andmebaasist internships tabelist) kõik praktika pakkumised",
            description = "Kui regionId on 0 ja/või categoryId on 0, siis tagastatakse kõik pakkumised ")
    public List<InternshipDto> getInternships(@RequestParam Integer sortValue, @RequestParam Integer regionId, @RequestParam Integer categoryId) {
        List<InternshipDto> internships = internshipsService.getInternships(sortValue, regionId, categoryId);
        return internships;


    }


    @PostMapping("/new-offer")
    @Operation(summary = "Uue praktika pakkumise lisamine.")
    public void addInternship(@RequestBody InternshipDto internshipDto){
    internshipsService.addInternship(internshipDto);
    }
}

