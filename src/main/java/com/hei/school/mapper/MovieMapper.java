package com.hei.school.mapper;

import com.hei.school.model.Movie;
import com.hei.school.repository.model.JMovie;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieMapper {
  private final ProjectionMapper projectionMapper;

  public Movie toModel(JMovie entity) {
    return Movie.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .genres(entity.getGenres())
        .description(entity.getDescription())
        .duration(entity.getDuration())
        .projections(
            entity.getProjections().stream()
                .map(projectionMapper::toModel)
                .collect(Collectors.toSet()))
        .build();
  }

  public List<Movie> toModel(List<JMovie> entities) {
    return entities.stream().map(this::toModel).toList();
  }

  public JMovie toEntity(Movie model) {
    return JMovie.builder()
        .id(model.id())
        .title(model.title())
        .genres(model.genres())
        .description(model.description())
        .duration(model.duration())
        .projections(
            model.projections().stream()
                .map(projectionMapper::toEntity)
                .collect(Collectors.toSet()))
        .build();
  }

  public List<JMovie> toEntity(List<Movie> models) {
    return models.stream().map(this::toEntity).toList();
  }
}
