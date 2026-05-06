package com.famcloud.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FolderRequest {
    private String name;
    private Long parentId;
    private Long userId;
    private boolean isFamilyFolder;
}
