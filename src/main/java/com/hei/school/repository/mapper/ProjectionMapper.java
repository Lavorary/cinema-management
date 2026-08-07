package com.hei.school.repository.mapper;

import com.hei.school.model.Projection;
import com.hei.school.model.Room;
import com.hei.school.repository.model.JMovie;
import com.hei.school.repository.model.JProjection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProjectionMapper {
    public Projection toModel(JProjection jProjection) {
        if (jProjection == null) return null;

        Projection projection = new Projection();
        projection.setId(UUID.fromString(jProjection.getId()));
        projection.setDatetime(jProjection.getDate());
        projection.setSeatPrice(jProjection.getSeatPrice());
        projection.setMovie(jProjection.getMovie());
        projection.setRoom((Room) jProjection.getRoom());
        return projection;
    }


    public JProjection toEntity(Projection projection) {
        if (projection == null) return null;

        JProjection jProjection = new JProjection();
        jProjection.setId(String.valueOf(projection.getId()));
        jProjection.setDate(projection.getDatetime());
        jProjection.setSeatPrice(projection.getSeatPrice());
        jProjection.setMovie((JMovie) projection.getMovie());
        jProjection.setRoom(projection.getRoom());
        return jProjection;
    }
}
