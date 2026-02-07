package com.book.hdn.repository;

import com.book.hdn.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    List<Page> findByChapterIdOrderByPageNumber(Long chapterId);
}