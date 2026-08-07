package com.hei.school.repository.model;

import com.hei.school.enums.Genre;
import com.hei.school.model.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class JMovie extends Movie {
  @Id @UuidGenerator private UUID id;

  private String title;

  private List<Genre> genres;

  private String description;

  private Duration duration;
}
