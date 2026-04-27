package com.famcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "role")
    private UserRole role;

    @Column(nullable = false,name = "createdAt")
    private LocalDateTime createdAt;
}
