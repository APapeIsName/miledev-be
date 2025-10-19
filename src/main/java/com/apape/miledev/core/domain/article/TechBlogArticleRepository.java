package com.apape.miledev.core.domain.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechBlogArticleRepository extends JpaRepository<TechBlogArticle, Long> {

    Page<TechBlogArticle> findAll(Pageable pageable);
}
