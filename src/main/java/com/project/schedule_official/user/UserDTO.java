package com.project.schedule_official.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    @Email(message = "Not valid email  format")
    @NotEmpty(message = "User's email can't be null")
    private String email;

    @NotBlank(message = "User's name can't be empty")
    @NotEmpty(message = "User's name can't be null")
    private String name;

    @NotBlank(message = "Password can't be empty")
    @NotEmpty(message = "Password can't be null")
    private String password;

    private Integer userId;

    public static UserDTO ofUser(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .userId(user.getUserId())
                .build();
    }

}
