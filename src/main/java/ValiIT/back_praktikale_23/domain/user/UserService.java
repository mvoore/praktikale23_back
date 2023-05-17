package ValiIT.back_praktikale_23.domain.user;

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
        if (userOptional.isEmpty()) {
            throw new RuntimeException();
        }
        User user = userOptional.get();
        return user;
    }
}
