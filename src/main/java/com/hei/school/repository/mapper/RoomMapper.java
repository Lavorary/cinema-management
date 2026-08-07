package com.hei.school.repository.mapper;

import com.hei.school.model.Room;
import com.hei.school.repository.model.JRoom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomMapper {
  public Room toModel(JRoom jroom) {
    if (jroom == null) return null;

    Room room = new Room();
    room.setId(jroom.getId());
    room.setNumber(jroom.getNumber());
    room.setCapacity(jroom.getCapacity());
    return room;
  }

  public JRoom toEntity(Room room) {
    if (room == null) return null;
    JRoom jroom = new JRoom();
    jroom.setId(room.getId());
    jroom.setNumber(room.getNumber());
    jroom.setCapacity(room.getCapacity());
    return jroom;
  }
}
