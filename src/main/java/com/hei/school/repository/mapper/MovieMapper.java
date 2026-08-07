package com.hei.school.repository.mapper;

import com.hei.school.enums.Genre;
import com.hei.school.model.Movie;
import com.hei.school.repository.model.JMovie;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieMapper {

  public Movie toModel(JMovie movie) {
    if (movie == null) return null;

    Movie model = new Movie();
    model.setId(UUID.fromString(String.valueOf(movie.getId())));
    model.setTitle(movie.getTitle());
    model.setDescription(movie.getDescription());
    model.setDuration(movie.getDuration());
    model.setGenres(Collections.singletonList(Genre.valueOf(String.valueOf(movie.getGenres()))));
    return model;
  }

  public JMovie toEntity(Movie movie) {
    if (movie == null) return null;

    JMovie model = new JMovie();
    model.setId(movie.getId());
    model.setTitle(movie.getTitle());
    model.setDescription(movie.getDescription());
    model.setDuration(movie.getDuration());
    model.setGenres(Collections.singletonList(Genre.valueOf(movie.getGenres().toString())));
    return model;
  }

  private List<Genre> parseGenres(String genresStr) {
    if (genresStr == null || genresStr.isEmpty()) {
      return List.of();
    }
    return Arrays.stream(genresStr.split(","))
        .map(String::trim)
        .map(Genre::valueOf)
        .collect(Collectors.toList());
  }

  private String serializeGenres(List<Genre> genres) {
    if (genres == null || genres.isEmpty()) {
      return "";
    }
    return genres.stream().map(Genre::name).collect(Collectors.joining(","));
  }
}
