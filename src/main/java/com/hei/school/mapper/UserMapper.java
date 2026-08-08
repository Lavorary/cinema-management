package com.hei.school.mapper;

import com.hei.school.model.User;
import com.hei.school.repository.model.JUser;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
  private final ReservationMapper reservationMapper;

  public User toModel(JUser entity) {
    return User.builder()
        .id(entity.getId())
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .birthDate(entity.getBirthDate())
        .email(entity.getEmail())
        .password(entity.getPassword())
        .phone(entity.getPhone())
        .role(entity.getRole())
        .reservations(
            entity.getReservations().stream()
                .map(reservationMapper::toModel)
                .collect(Collectors.toSet()))
        .build();
  }

  public List<User> toModel(List<JUser> entities) {
    return entities.stream().map(this::toModel).toList();
  }

  public JUser toEntity(User model) {
    return JUser.builder()
        .id(model.id())
        .firstName(model.firstName())
        .lastName(model.lastName())
        .birthDate(model.birthDate())
        .email(model.email())
        .password(model.password())
        .phone(model.phone())
        .role(model.role())
        .reservations(
            model.reservations().stream()
                .map(reservationMapper::toEntity)
                .collect(Collectors.toSet()))
        .build();
  }

  public List<JUser> toEntity(List<User> models) {
    return models.stream().map(this::toEntity).toList();
  }
}
