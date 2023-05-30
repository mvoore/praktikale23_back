package ValiIT.back_praktikale_23.business.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {
    private Integer userId;
    private Integer companyId;
    private String roleName;
}