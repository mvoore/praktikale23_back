package ValiIT.back_praktikale_23.business.login;

import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.domain.internship.company.CompanyService;
import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.UserMapper;
import ValiIT.back_praktikale_23.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private CompanyService companyService;
    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        setCompanyId(loginResponse, user.getId());
        return loginResponse;
    }

    private void setCompanyId(LoginResponse loginResponse, Integer userId) {
        Company company = companyService.findCompanyBy(userId);
        if (company == null) {
            loginResponse.setCompanyId(0);
        } else {
            loginResponse.setCompanyId(company.getId());
        }
    }
}
