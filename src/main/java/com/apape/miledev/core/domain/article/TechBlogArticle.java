package com.apape.miledev.core.domain.article;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@DiscriminatorValue("TECH_BLOG")
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class TechBlogArticle extends Article {

    private String sourceUrl;

    private String sourceFrom;

    public static TechBlogArticle create(
            String title,
            String thumbnailImageUrl,
            String sourceUrl,
            String sourceFrom
    ) {
        return builder()
                .title(title)
                .thumbnailImageUrl(thumbnailImageUrl)
                .sourceUrl(sourceUrl)
                .sourceFrom(sourceFrom)
                .build();
    }

    @Override
    public String entityName() {
        return "기술 블로그 게시글";
    }
}
