package com.hei.school.model;

import com.hei.school.enums.ReservationStatus;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Reservation (
  UUID id,
  Instant createdAt,
  ReservationStatus status,
  Projection projection,
  Set<Seat> seats) {}