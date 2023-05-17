package ValiIT.back_praktikale_23.business.login;

import ValiIT.back_praktikale_23.domain.user.User;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}