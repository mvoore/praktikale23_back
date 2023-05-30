package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class InternshipsController {

    @Resource
    private InternshipsService internshipsService;



    @GetMapping("/internships")
    @Operation(summary = "Leiab andmebaasist kõik praktika pakkumised",
            description = "Kui regionId on 0 ja/või categoryId on 0, siis tagastatakse kõik pakkumised ")
    public List<InternshipDto> getInternships(@RequestParam Integer sortValue, @RequestParam Integer regionId, @RequestParam Integer categoryId) {
        List<InternshipDto> internships = internshipsService.getInternships(sortValue, regionId, categoryId);
        return internships;
    }


    @PostMapping("/new-offer")
    @Operation(summary = "Uue praktika pakkumise lisamine.")
    public void addInternship(@RequestBody InternshipRequest internshipRequest){
    internshipsService.addInternship(internshipRequest);
    }

    @PutMapping("/new-offer")
    @Operation(summary = "Toob eelnevalt sisestatud praktika pakkumise detailid ja muudab andmed (kirjutab üle) ")
    public void editInternship(@RequestParam Integer internshipId, @RequestBody InternshipRequest request) {
        internshipsService.editInternship(internshipId, request);
    }



    @GetMapping("/company-internships")
    @Operation(summary = "Leiab andmebaasist konkreetse firma aktiivsed praktika pakkumised userId järgi")
    public List<CompanyInternshipDto> getCompanyInternships(@RequestParam Integer userId) {
        List<CompanyInternshipDto> companyInternships = internshipsService.getCompanyInternships(userId);
        return companyInternships;
    }
}

