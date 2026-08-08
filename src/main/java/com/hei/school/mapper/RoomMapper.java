package com.hei.school.mapper;

import com.hei.school.model.Room;
import com.hei.school.repository.model.JRoom;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomMapper {
  private final SeatMapper seatMapper;

  public Room toModel(JRoom entity) {
    return Room.builder()
        .id(entity.getId())
        .number(entity.getNumber())
        .capacity(entity.getCapacity())
        .seats(seatMapper.toModel(entity.getSeats()))
        .build();
  }

  public List<Room> toModel(List<JRoom> entities) {
    return entities.stream().map(this::toModel).toList();
  }

  public JRoom toEntity(Room model) {
    return JRoom.builder()
        .id(model.id())
        .number(model.number())
        .capacity(model.capacity())
        .seats(seatMapper.toEntity(model.seats()))
        .build();
  }

  public List<JRoom> toEntity(List<Room> models) {
    return models.stream().map(this::toEntity).toList();
  }
}
