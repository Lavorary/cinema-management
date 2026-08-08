package com.hei.school.model;

import com.hei.school.enums.Genre;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Movie(
    UUID id,
    String title,
    List<Genre> genres,
    String description,
    Duration duration,
    Set<Projection> projections) {}
