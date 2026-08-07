package com.hei.school.repository.mapper;

import com.hei.school.model.Room;
import com.hei.school.model.Seat;
import com.hei.school.repository.model.JSeat;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SeatMapper {
  public Seat toModel(JSeat jseat) {
    if (jseat == null) return null;

    Seat seat = new Seat();
    seat.setId(UUID.fromString(jseat.getId()));
    seat.setNumber(jseat.getNumber());
    seat.setRoom((Room) jseat.getRoom());
    return seat;
  }

  public JSeat toEntity(Seat seat) {
    if (seat == null) return null;

    JSeat jSeat = new JSeat();
    jSeat.setId(String.valueOf(seat.getId()));
    jSeat.setNumber(seat.getNumber());
    jSeat.setRoom(seat.getRoom());
    return jSeat;
  }
}
