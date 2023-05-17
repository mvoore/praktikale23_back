package ValiIT.back_praktikale_23.business.login;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}
