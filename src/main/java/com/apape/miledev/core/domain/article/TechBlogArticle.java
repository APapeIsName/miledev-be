package com.apape.miledev.core.domain.article;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@DiscriminatorValue("TECH_BLOG")
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class TechBlogArticle extends Article {

    private String sourceUrl;

    private String sourceFrom;

    private LocalDate publishedAt;

    public static TechBlogArticle create(
            String title,
            String thumbnailImageUrl,
            String sourceUrl,
            String sourceFrom,
            LocalDate publishedAt
    ) {
        return builder()
                .title(title)
                .thumbnailImageUrl(thumbnailImageUrl)
                .sourceUrl(sourceUrl)
                .sourceFrom(sourceFrom)
                .publishedAt(publishedAt)
                .build();
    }

    @Override
    public String entityName() {
        return "기술 블로그 게시글";
    }
}
