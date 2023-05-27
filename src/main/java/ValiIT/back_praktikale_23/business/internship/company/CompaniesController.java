package ValiIT.back_praktikale_23.business.internship.company;

import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyDto;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompaniesController {
    @Resource
    private CompaniesService companiesService;
    @Resource
    private CompanyMapper companyMapper;

    @GetMapping("/company")
    @Operation(summary = "Leiab andmebaasist company info userId kaudu.")
    public CompanyDto getCompanyInfo(@RequestParam Integer userId) {
        Company company = companiesService.getCompany(userId);
        return companyMapper.toDto(company);
    }
}
