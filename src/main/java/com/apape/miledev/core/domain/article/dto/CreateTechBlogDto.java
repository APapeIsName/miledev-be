package com.apape.miledev.core.domain.article.dto;

import java.time.LocalDate;
import java.util.List;

public record CreateTechBlogDto(
        List<CreateTechBlogParam> techBlogDtos
) {
    public record CreateTechBlogParam(
            String title,
            String thumbnailImageUrl,
            String sourceUrl,
            String sourceFrom,
            LocalDate publishedAt
    ) {}
}
