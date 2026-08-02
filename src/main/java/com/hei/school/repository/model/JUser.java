package com.hei.school.repository.model;

import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class JUser {
    @Id @UuidGenerator
    private String id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String email;

    private String password;

    private String phone;

    private String role;
}
