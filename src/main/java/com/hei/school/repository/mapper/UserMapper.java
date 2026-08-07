// src/main/java/com/hei/school/repository/mapper/UserMapper.java
package com.hei.school.repository.mapper;

import com.hei.school.enums.UserRole;
import com.hei.school.model.Reservation;
import com.hei.school.model.User;
import com.hei.school.repository.model.JUser;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toModel(JUser jUser) {
    if (jUser == null) return null;

    return User.builder()
        .id(UUID.fromString(jUser.getId()))
        .firstName(jUser.getFirstName())
        .lastName(jUser.getLastName())
        .birthdate(jUser.getBirthDate())
        .email(jUser.getEmail())
        .password(jUser.getPassword())
        .phone(jUser.getPhone())
        .role(UserRole.valueOf(jUser.getRole()))
        .reservation(new Reservation())
        .build();
  }

  public JUser toEntity(User user) {
    if (user == null) return null;

    JUser jUser = new JUser();
    jUser.setId(String.valueOf(user.id()));
    jUser.setFirstName(user.firstName());
    jUser.setLastName(user.lastName());
    jUser.setBirthDate(user.birthdate());
    jUser.setEmail(user.email());
    jUser.setPassword(user.password());
    jUser.setPhone(user.phone());
    jUser.setRole(user.role().name());
    return jUser;
  }
}
