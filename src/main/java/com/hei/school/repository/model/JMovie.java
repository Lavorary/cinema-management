package com.hei.school.repository.model;

import com.hei.school.model.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class JMovie extends Movie {
  @Id @UuidGenerator private String id;

  private String title;

  private String genres;

  private String description;

  private Long duration;
}
