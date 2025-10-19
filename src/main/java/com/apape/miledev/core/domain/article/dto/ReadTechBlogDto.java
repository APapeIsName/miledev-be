package com.apape.miledev.core.domain.article.dto;

import java.time.LocalDate;

public record ReadTechBlogDto(
        String title,
        String thumbnailImageUrl,
        String sourceUrl,
        String publishedFrom,
        LocalDate publishedAt
) {

}
