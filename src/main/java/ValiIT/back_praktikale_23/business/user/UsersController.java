package ValiIT.back_praktikale_23.business.user;

import ValiIT.back_praktikale_23.business.user.dto.NewUserRequest;
import ValiIT.back_praktikale_23.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/signup")
    @Operation(summary = "Uue kasutaja registreerimine. Lisab Kasutaja andmed Admebaasi")

    public void addNewUser(@RequestBody NewUserRequest newUserRequest) {
        usersService.addNewUser(newUserRequest);



    }

}
