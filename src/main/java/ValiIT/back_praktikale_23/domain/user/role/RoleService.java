package ValiIT.back_praktikale_23.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
   private RoleRepository roleRepository;

    public Role findRoleBy(Integer roleId) {
        Role role = roleRepository.findById(roleId).get();
        return role;

    }
}
