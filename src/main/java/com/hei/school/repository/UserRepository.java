package com.hei.school.repository;

import com.hei.school.repository.model.JUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<JUser, String> {
  JUser findByEmail(String email);
}
