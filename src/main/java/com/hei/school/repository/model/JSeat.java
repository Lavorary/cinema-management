package com.hei.school.repository.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "seats")
@Builder
public class JSeat {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String number;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_id")
  private JRoom room;

  @ManyToMany(mappedBy = "seats")
  private Set<JReservation> reservations;
}
