package com.hei.school.repository;

import com.hei.school.repository.model.JRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<JRoom, String> {}
