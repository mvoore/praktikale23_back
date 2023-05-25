package ValiIT.back_praktikale_23.domain.internship.company;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;


    public Company findCompanyBy(Integer userId) {
        Company company = companyRepository.findCompanyBy(userId);
        return company;
    }
}
