package tech.fivedhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.fivedhub.dto.UserDto;
import tech.fivedhub.service.UserService;
import tech.fivedhub.mapper.UserMapper;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto getUserDtoById(@PathVariable long userId) {
        return userMapper.toUserDto(userService.getUserById(userId));
    }

    @GetMapping("/{lastName}")
    public UserDto getUserDtoByLastName(@PathVariable String lastName) {
        return userMapper.toUserDto(userService.getUserByLastName(lastName));
    }
}
