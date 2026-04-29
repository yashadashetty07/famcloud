package com.famcloud.repository;

import com.famcloud.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long> {
    List<Folder> findByUserId(Long userId);
    List<Folder> findByParent_Id(Long parentId);

}
