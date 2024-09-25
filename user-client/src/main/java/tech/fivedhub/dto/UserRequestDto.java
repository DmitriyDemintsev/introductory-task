package tech.fivedhub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
}
