package com.hei.school.model;

import com.hei.school.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Builder
public record User(
        UUID id,
        String firstName,
        String lastName,
        LocalDate birthdate,
        String email,
        String password,
        String phone,
        UserRole role
) {
}
