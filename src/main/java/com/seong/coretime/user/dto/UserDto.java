package com.seong.coretime.user.dto;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserDto {
    private String name;
    private String email;
    private String password;
}
