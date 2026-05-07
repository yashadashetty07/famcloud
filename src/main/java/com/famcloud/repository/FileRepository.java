package com.famcloud.repository;

import com.famcloud.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File,Long> {
    List<File> findByFolder_Id(Long folderId);

    List<File> findByUserId(Long userId);
}
