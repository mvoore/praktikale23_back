package ValiIT.back_praktikale_23.business.internship.company;

import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyDto;
import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyModifyRequest;
import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyRequest;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompaniesController {
    @Resource
    private CompaniesService companiesService;
    @Resource
    private CompanyMapper companyMapper;

    @GetMapping
    @Operation(summary = "Leiab andmebaasist company info userId kaudu.")
    public CompanyDto getCompanyInfo(@RequestParam Integer userId) {
        Company company = companiesService.getCompany(userId);
        return companyMapper.toDto(company);
    }

    @PostMapping
    @Operation(summary = "Lisab andmebaasi uue ettevõtte info")
    public void addCompany(@RequestBody CompanyRequest companyRequest) {
        companiesService.addCompany(companyRequest);
    }

    @PutMapping
    @Operation(summary = "Leiab andmebaasist ettevõtte info ja muudab selle")
    public void editCompany(@RequestParam Integer companyId, @RequestBody CompanyModifyRequest request) {
        companiesService.editCompany(companyId, request);
    }
}
