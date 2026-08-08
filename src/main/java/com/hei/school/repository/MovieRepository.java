package com.hei.school.repository;

import com.hei.school.repository.model.JMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<JMovie, String> {
  JMovie findByTitle(String title);
}
