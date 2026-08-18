package com.hei.school.model;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
  private UUID id;
  private String number;
  private int capacity;
  private List<Seat> seats;
  private List<Projection> projections;
}
