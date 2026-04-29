package com.famcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "folders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false,name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Folder parent;

    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false,name = "is_family_folder")
    private boolean isFamilyFolder;

    @Column(nullable = false,name = "created_at")
    private LocalDateTime createdAt;
}
