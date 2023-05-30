package ValiIT.back_praktikale_23.business.user;


import ValiIT.back_praktikale_23.business.user.dto.NewUserRequest;
import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.domain.user.UserMapper;
import ValiIT.back_praktikale_23.domain.user.UserService;
import ValiIT.back_praktikale_23.domain.user.role.Role;
import ValiIT.back_praktikale_23.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleService roleService;




    public void addNewUser(NewUserRequest newUserRequest) {
        userService.validateUsernameIsAvailable(newUserRequest.getUsername());
        User user = userMapper.toUser(newUserRequest);
        Role role = roleService.findRoleBy(newUserRequest.getRoleId());
        user.setRole(role);
        userService.addUser(user);
    }
}

