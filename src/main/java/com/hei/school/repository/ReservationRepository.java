package com.hei.school.repository;

import com.hei.school.repository.model.JReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<JReservation, String> {}
