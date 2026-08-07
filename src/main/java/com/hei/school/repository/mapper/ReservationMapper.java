// src/main/java/com/hei/school/repository/mapper/ReservationMapper.java
package com.hei.school.repository.mapper;

import com.hei.school.enums.ReservationStatus;
import com.hei.school.model.Reservation;
import com.hei.school.repository.model.JReservation;
import com.hei.school.repository.model.JSeat;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationMapper {

  private final UserMapper userMapper;
  private final ProjectionMapper projectionMapper;
  private final SeatMapper seatMapper;

  public List<Reservation> toModel(List<JReservation> jReservations) {
    return jReservations.stream().map(this::toModel).toList();
  }

  public Reservation toModel(JReservation jReservation) {
    if (jReservation == null) return null;

    Reservation reservation = new Reservation();
    reservation.setId(UUID.fromString(jReservation.getId()));
    reservation.setCreatedAt(jReservation.getCreatedAt());
    reservation.setStatus(ReservationStatus.valueOf(jReservation.getStatus()));

    if (jReservation.getUser() != null) {
      reservation.setUser(userMapper.toModel(jReservation.getUser()));
    }
    if (jReservation.getProjection() != null) {
      reservation.setProjection(projectionMapper.toModel(jReservation.getProjection()));
    }
    if (jReservation.getSeats() != null) {
      reservation.setSeat(seatMapper.toModel((JSeat) jReservation.getSeats()));
    }

    return reservation;
  }

  public List<JReservation> toEntity(List<Reservation> reservations) {
    return reservations.stream().map(this::toEntity).toList();
  }

  public JReservation toEntity(Reservation reservation) {
    if (reservation == null) return null;

    JReservation jReservation = new JReservation();
    jReservation.setId(String.valueOf(reservation.getId()));
    jReservation.setCreatedAt(reservation.getCreatedAt());
    jReservation.setStatus(reservation.getStatus().name());

    if (reservation.getUser() != null) {
      jReservation.setUser(userMapper.toEntity(reservation.getUser()));
    }
    if (reservation.getProjection() != null) {
      jReservation.setProjection(projectionMapper.toEntity(reservation.getProjection()));
    }
    if (reservation.getSeat() != null) {
      jReservation.setSeats((List<JSeat>) seatMapper.toEntity(reservation.getSeat()));
    }

    return jReservation;
  }
}
