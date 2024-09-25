package tech.fivedhub.mapper;

import org.springframework.stereotype.Component;
import tech.fivedhub.dto.UserDto;
import tech.fivedhub.model.User;

@Component
public class UserMapper {

    public static User toUser(UserDto userDto, long userId) {
        User user = new User(
                userId,
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getPhone()
        );
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getUserId(),
                user.getFirstName(),
                user.getFirstName(),
                user.getPhone()
        );
        return userDto;
    }
}
