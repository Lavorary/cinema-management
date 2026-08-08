package com.hei.school.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "rooms")
public class JRoom {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String number;

  private Integer capacity;

  @OneToMany(mappedBy = "room_id", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<JSeat> seats;

  @OneToMany(mappedBy = "room_id", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<JProjection> projections;
}
