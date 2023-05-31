package ValiIT.back_praktikale_23.domain.user;

import ValiIT.back_praktikale_23.business.login.LoginResponse;
import ValiIT.back_praktikale_23.business.user.dto.NewUserRequest;
import ValiIT.back_praktikale_23.business.user.dto.UserDto;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @Mapping(constant = "A",target = "status")
    User toUser(NewUserRequest newUserRequest);

    UserDto toDto(User user);

}

