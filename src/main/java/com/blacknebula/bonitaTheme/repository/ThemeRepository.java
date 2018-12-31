package com.blacknebula.bonitaTheme.repository;

import com.blacknebula.bonitaTheme.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    @Modifying
    @Query("update Theme t set t.content = ?2 where t.id = ?1")
    @Transactional
    void updateContent(Long id, byte[] content);

    @Modifying
    @Query("update Theme t set t.cssContent = ?2 where t.id = ?1")
    @Transactional
    void updateCssContent(Long id, byte[] cssContent);
}