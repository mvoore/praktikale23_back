package ValiIT.back_praktikale_23.business.internship;

import ValiIT.back_praktikale_23.business.internship.dto.CompanyInternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipDto;
import ValiIT.back_praktikale_23.business.internship.dto.InternshipOffer;
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
    public void addInternship(@RequestBody InternshipOffer internshipOffer){
    internshipsService.addInternship(internshipOffer);
    }

    @PutMapping("/edit-internship")
    @Operation(summary = "Toob eelnevalt sisestatud praktika pakkumise detailid ja muudab andmed (kirjutab üle) ")
    public void editInternship(@RequestParam Integer internshipId, @RequestBody InternshipOffer request) {
        internshipsService.editInternship(internshipId, request);
    }

    @GetMapping("/active-internships")
    @Operation(summary = "Leiab andmebaasist firma aktiivsed praktika pakkumised userId järgi")
    public List<CompanyInternshipDto> getActiveInternships(@RequestParam Integer userId) {
        List<CompanyInternshipDto> activeInternships = internshipsService.getActiveInternships(userId);
        return activeInternships;
    }

    @GetMapping("/inactive-internships")
    @Operation(summary = "Leiab andmebaasist firma mitte aktiivsed praktika pakkumised userId Järgi")
    public List<CompanyInternshipDto> getInactiveInternships(@RequestParam Integer userId) {
        List<CompanyInternshipDto> inactiveInternships = internshipsService.getInactiveInternships(userId);
        return inactiveInternships;
    }

    @GetMapping("/offer")
    @Operation(summary ="Leiab andmebaasist konkreetse praktika pakkumise (internshipId alusel) info.")
    public InternshipOffer getInternshipOffer(@RequestParam Integer internshipId) {
        return internshipsService.getInternshipOffer(internshipId);
    }

}

