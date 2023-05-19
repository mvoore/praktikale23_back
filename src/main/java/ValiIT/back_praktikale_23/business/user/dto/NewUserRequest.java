package ValiIT.back_praktikale_23.business.user.dto;

import lombok.Data;

@Data
public class NewUserRequest {
    private String username;
    private String password;
    private Integer roleId;
}
