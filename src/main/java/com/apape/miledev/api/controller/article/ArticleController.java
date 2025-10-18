package com.apape.miledev.api.controller.article;

import com.apape.miledev.core.domain.article.TechBlogArticleService;
import com.apape.miledev.core.domain.article.dto.CreateTechBlogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final TechBlogArticleService techBlogArticleService;

    @PostMapping
    public CreateTechBlogDto postArticle(@RequestBody CreateTechBlogDto dto) {
        return techBlogArticleService.create(dto);
    }
}
