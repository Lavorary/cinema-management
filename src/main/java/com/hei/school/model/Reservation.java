package com.hei.school.model;

import com.hei.school.enums.ReservationStatus;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
  private UUID id;
  private Instant createdAt;
  private ReservationStatus status;
  private User user;
  private Projection projection;
  private Seat seat;
}
