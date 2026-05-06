package com.famcloud.service;

import com.famcloud.dto.FolderRequest;
import com.famcloud.dto.FolderResponse;
import com.famcloud.entity.Folder;
import com.famcloud.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    public FolderResponse createFolder(FolderRequest request) {
        Folder parent = null;
        if (request.getParentId() != null) {
            parent = folderRepository.findById(request.getParentId()).orElseThrow(() -> new RuntimeException("Parent Folder not Found"));
        }

        Folder newFolder = Folder.builder()
                .name(request.getName())
                .parent(parent)
                .userId(request.getUserId())
                .isFamilyFolder(request.isFamilyFolder())
                .createdAt(LocalDateTime.now())
                .build();

        Folder savedFolder = folderRepository.save(newFolder);
        return mapToResponse(savedFolder);

    }

    public List<FolderResponse> getRootFolders(Long userId) {
        return folderRepository.findByUserIdAndParent_Id(userId, null).stream().map(this::mapToResponse).toList();
    }

    public List<FolderResponse> getChildFolders(Long parentId) {
        return folderRepository.findByParent_Id(parentId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    private FolderResponse mapToResponse(Folder folder) {
        return FolderResponse.builder()
                .id(folder.getId())
                .name(folder.getName())
                .parentId(folder.getParent() != null ? folder.getParent().getId() : null)
                .userId(folder.getUserId())
                .isFamilyFolder(folder.isFamilyFolder())
                .createdAt(folder.getCreatedAt())
                .build();
    }
}
