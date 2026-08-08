package com.hei.school.repository;

import com.hei.school.repository.model.JSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<JSeat, String> {}
