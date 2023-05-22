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


// TODO: controlleris actionit ei tee, kasutame controlleri nimelist servicet (UsersService)
// TODO: Kõige pealt peaks valideerima, kas valitud username on vaba. Kui mitte siis visata viga. (valideerimiseks userService->userRepository) - DONE
// TODO: meil on vaia dto (newUserRequest) mäppida ümber entity-ks (user).
// TODO: entity 'user' on siis mingi tabeli (user) ühe rea objekt
//  võtame mapperiga nii palju andmeid dto'st (newUserRequest) kui suudame. DONE
//  Kui meile tulevad sisse mingid foreign keyd (roleId), siis neid väärtusi me ei mäpi
//  Peale mäppimist meil on olemas uus objekt entity'st ('user' andmebaasi üks rida)
//  nii paljude andmetega kui saime ära mäppida - DONE
//  Foreing keyde osas (roleId) peate tegema nii, et te leiate andmebaasist (roleService->roleRepositoryu)
//  konkreetselt selle id objekti 'role' ja siis panete setteriga selle 'user' objetki külge.
//  Siis kui 'user' objekti küljes kõik vajalikud andmed olemas, siis salvestame selle rea ära (userService->userRepository) -DONE