package com.famcloud.controller;

import com.famcloud.dto.FolderRequest;
import com.famcloud.dto.FolderResponse;
import com.famcloud.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/folders")
@RequiredArgsConstructor
public class FolderController {

    @Autowired
    private final FolderService folderService;

    @PostMapping
    public ResponseEntity<FolderResponse> createFolder(@RequestBody FolderRequest request) {
        return ResponseEntity.status(201).body(folderService.createFolder(request));
    }

    @GetMapping("/root")
    public ResponseEntity<List<FolderResponse>> getRootFolders(@RequestParam Long userId) {
        return ResponseEntity.ok(folderService.getRootFolders(userId));
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<List<FolderResponse>> getChildFolders(@PathVariable Long parentId) {
        return ResponseEntity.ok(folderService.getChildFolders(parentId));
    }
}
