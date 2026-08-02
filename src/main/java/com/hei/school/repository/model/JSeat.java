package com.hei.school.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seats")
public class JSeat {
  @Id @UuidGenerator private String id;

  private String number;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_id")
  private JRoom room;
}
