package ValiIT.back_praktikale_23.domain.user;

import ValiIT.back_praktikale_23.domain.internship.company.Company;
import ValiIT.back_praktikale_23.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ValiIT.back_praktikale_23.business.Status.ACTIVE;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password, ACTIVE.getLetter());

        ValidationService.validateCorrectUserCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }

    public void validateUsernameIsAvailable(String username) {
        boolean userExists = userRepository.userExistsBy(username);
        ValidationService.validateUsernameIsAvailable(userExists);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    public User findUserBy(Company company, Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return user;
    }
}
