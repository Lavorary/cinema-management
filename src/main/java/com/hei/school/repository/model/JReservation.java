package com.hei.school.repository.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class JReservation {
  @Id @UuidGenerator private String id;

  private Instant createdAt;

  private String status;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private JUser user;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projection_id")
  private JProjection projection;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "seat_id")
  private List<JSeat> seats;
}
