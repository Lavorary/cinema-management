package com.hei.school.mapper;

import com.hei.school.model.Reservation;
import com.hei.school.repository.model.JReservation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationMapper {
  private final SeatMapper seatMapper;
  private final ProjectionMapper projectionMapper;

  public Reservation toModel(JReservation entity) {
    return Reservation.builder()
        .id(entity.getId())
        .createdAt(entity.getCreatedAt())
        .status(entity.getStatus())
        .projection(projectionMapper.toModel(entity.getProjection()))
        .seats(entity.getSeats().stream().map(seatMapper::toModel).collect(Collectors.toSet()))
        .build();
  }

  public List<Reservation> toModel(List<JReservation> entities) {
    return entities.stream().map(this::toModel).toList();
  }

  public JReservation toEntity(Reservation model) {
    return JReservation.builder()
        .id(model.id())
        .createdAt(model.createdAt())
        .status(model.status())
        .projection(projectionMapper.toEntity(model.projection()))
        .seats(model.seats().stream().map(seatMapper::toEntity).collect(Collectors.toSet()))
        .build();
  }

  public List<JReservation> toEntity(List<Reservation> models) {
    return models.stream().map(this::toEntity).toList();
  }
}
