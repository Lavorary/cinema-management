package com.hei.school.repository.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projections")
public class JProjection {
  @Id @UuidGenerator private String id;

  private Instant date;

  private BigDecimal seatPrice;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_id")
  private JMovie movie;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_id")
  private JRoom room;
}
