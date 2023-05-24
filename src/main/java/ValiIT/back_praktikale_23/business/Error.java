package ValiIT.back_praktikale_23.business;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool",111),
    USER_EXISTS("Selline kasutajanimi on juba olemas",222);


    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
