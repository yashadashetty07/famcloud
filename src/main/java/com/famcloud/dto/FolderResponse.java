package com.famcloud.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FolderResponse {

    private Long id;
    private String name;
    private Long parentId;
    private Long userId;
    private boolean isFamilyFolder;
    private LocalDateTime createdAt;
}