package ValiIT.back_praktikale_23.business.internship.company;

import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CompaniesService {
    @Resource
    private CompanyService companyService;

    public Company getCompany(Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        return company;

    }
}
