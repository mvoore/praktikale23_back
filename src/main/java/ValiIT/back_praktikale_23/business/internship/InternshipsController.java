package ValiIT.back_praktikale_23.business.internship;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class InternshipsController {

    @Resource
    private InternshipsService internshipsService;


    @GetMapping("/internships")
    @Operation(summary = "Leiab süsteemist (andmebaasist internships tabelist) kõik praktika pakkumised")
    public List<InternshipDto> getInternships(@RequestParam Integer regionId, @RequestParam Integer categoryId){
        List<InternshipDto>internships = internshipsService.getInternships(regionId,categoryId);
        return internships;


    }





}
