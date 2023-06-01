package ValiIT.back_praktikale_23.business.internship.company;

import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyModifyRequest;
import ValiIT.back_praktikale_23.business.internship.company.dto.CompanyRequest;
import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyMapper;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyService;
import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompaniesService {
    @Resource
    private CompanyService companyService;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private UserService userService;

    public Company getCompany(Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        return company;
    }

    public void addCompany(CompanyRequest request) {
        Company company = companyMapper.toEntity(request);
        User user = userService.findUserBy(company, request.getUserId());
        company.setUser(user);
        companyService.addCompany(company);
    }

    @Transactional
    public void editCompany(Integer companyId, CompanyModifyRequest request) {
        Company company = companyService.getCompanyBy(companyId);
        companyMapper.partialUpdate(request, company);
        companyService.addCompany(company);
    }
}
