package ValiIT.back_praktikale_23.validation;


import ValiIT.back_praktikale_23.domain.user.User;
import ValiIT.back_praktikale_23.infrastructure.exception.BusinessException;

import java.util.Optional;

import static ValiIT.back_praktikale_23.business.Error.INCORRECT_CREDENTIALS;
import static ValiIT.back_praktikale_23.business.Error.USER_EXISTS;

public class ValidationService {

    public static void validateCorrectUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
    }

    public static void validateUsernameIsAvailable(boolean userExists) {
        if (userExists) {
            throw new BusinessException(USER_EXISTS.getMessage(), USER_EXISTS.getErrorCode());
        }
    }

}
