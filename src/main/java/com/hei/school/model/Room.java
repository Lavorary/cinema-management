package com.hei.school.model;

import com.hei.school.repository.model.JRoom;
import java.util.List;
import java.util.UUID;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room extends JRoom {
  private UUID id;
  private String number;
  private Integer capacity;
  private List<Seat> seats;
  private List<Projection> projections;
}
