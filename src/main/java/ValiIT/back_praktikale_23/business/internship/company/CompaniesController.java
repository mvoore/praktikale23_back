package ValiIT.back_praktikale_23.business.internship.company;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompaniesController {
    @Resource
    private CompaniesService companiesService;

    @GetMapping("/company")
    @Operation(summary = "Leiab andmebaasist company info userId kaudu.")
    public void getCompanyInfo(@RequestParam Integer userId) {
        companiesService.getCompany(userId);
    }
}
