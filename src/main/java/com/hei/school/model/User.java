package com.hei.school.model;

import com.hei.school.enums.UserRole;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;

@Builder
public record User(
    UUID id,
    String firstName,
    String lastName,
    LocalDate birthDate,
    String email,
    String password,
    String phone,
    UserRole role,
    Set<Reservation> reservations) {}
