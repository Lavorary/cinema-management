package com.hei.school.repository.model;

import com.hei.school.enums.Genre;
import jakarta.persistence.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movies")
@Builder
public class JMovie {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String title;

  @Enumerated(EnumType.STRING)
  private List<Genre> genres;

  private String description;

  private Duration duration;

  @OneToMany(
      mappedBy = "movie_id",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  private Set<JProjection> projections;
}
