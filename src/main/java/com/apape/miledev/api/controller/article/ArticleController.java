package com.apape.miledev.api.controller.article;

import com.apape.miledev.core.domain.article.TechBlogArticleService;
import com.apape.miledev.core.domain.article.dto.CreateTechBlogDto;
import com.apape.miledev.core.domain.article.dto.ReadTechBlogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final TechBlogArticleService techBlogArticleService;

    @PostMapping
    public CreateTechBlogDto postArticle(@RequestBody CreateTechBlogDto dto) {
        return techBlogArticleService.create(dto);
    }

    @GetMapping
    public Page<ReadTechBlogDto> readAllArticles(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return techBlogArticleService.readTechBlogList(page, size);
    }
}
