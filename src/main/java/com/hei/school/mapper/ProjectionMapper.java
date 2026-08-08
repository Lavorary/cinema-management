package com.hei.school.mapper;

import com.hei.school.model.Projection;
import com.hei.school.repository.model.JProjection;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectionMapper {
  private final RoomMapper roomMapper;

  public Projection toModel(JProjection entity) {
    return Projection.builder()
        .id(entity.getId())
        .datetime(entity.getDatetime())
        .seatPrice(entity.getSeatPrice())
        .room(roomMapper.toModel(entity.getRoom()))
        .build();
  }

  public List<Projection> toModel(List<JProjection> entities) {
    return entities.stream().map(this::toModel).toList();
  }

  public JProjection toEntity(Projection model) {
    return JProjection.builder()
        .id(model.id())
        .datetime(model.datetime())
        .seatPrice(model.seatPrice())
        .room(roomMapper.toEntity(model.room()))
        .build();
  }

  public List<JProjection> toEntity(List<Projection> models) {
    return models.stream().map(this::toEntity).toList();
  }
}
