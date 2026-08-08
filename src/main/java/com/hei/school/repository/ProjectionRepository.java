package com.hei.school.repository;

import com.hei.school.repository.model.JProjection;
import com.hei.school.repository.model.JReservation;
import com.hei.school.repository.model.JSeat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectionRepository extends JpaRepository<JProjection, String> {
  List<JReservation> findByProjectionId(String projectionId);

  @Query("SELECT s FROM JReservation r JOIN r.seats s WHERE r.projection.id = :projectionId")
  List<JSeat> findReservedSeatsByProjection(@Param("projectionId") String projectionId);
}
