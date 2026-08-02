package com.hei.school.model;

import com.hei.school.enums.Genre;
import java.time.Duration;
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
public class Movie {
  private UUID id;
  private String title;
  private List<Genre> genres;
  private String description;
  private Duration duration;
}
