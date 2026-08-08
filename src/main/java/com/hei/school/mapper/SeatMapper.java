package com.hei.school.mapper;

import com.hei.school.model.Seat;
import com.hei.school.repository.model.JSeat;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SeatMapper {
  public Seat toModel(JSeat entity) {
    return Seat.builder().id(entity.getId()).number(entity.getNumber()).build();
  }

  public List<Seat> toModel(List<JSeat> entities) {
    return entities.stream().map(this::toModel).toList();
  }

  public JSeat toEntity(Seat model) {
    return JSeat.builder().id(model.id()).number(model.number()).build();
  }

  public List<JSeat> toEntity(List<Seat> models) {
    return models.stream().map(this::toEntity).toList();
  }
}
