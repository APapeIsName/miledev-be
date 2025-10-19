package com.apape.miledev.core.domain.article;

import com.apape.miledev.core.domain.article.dto.CreateTechBlogDto;
import com.apape.miledev.core.domain.article.dto.ReadTechBlogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TechBlogArticleService {

    private final TechBlogArticleRepository techBlogArticleRepository;

    @Transactional
    public CreateTechBlogDto create(
            CreateTechBlogDto request
    ) {
        List<TechBlogArticle> articles = request.techBlogDtos().stream().map(techBlogDto -> TechBlogArticle.create(
                techBlogDto.title(),
                techBlogDto.thumbnailImageUrl(),
                techBlogDto.sourceUrl(),
                techBlogDto.sourceFrom(),
                techBlogDto.publishedAt()
        )).toList();

        List<TechBlogArticle> savedTechBlogArticles = techBlogArticleRepository.saveAll(articles);

        return new CreateTechBlogDto(
                savedTechBlogArticles.stream()
                        .map(techBlogArticle -> new CreateTechBlogDto.CreateTechBlogParam(
                                techBlogArticle.getTitle(),
                                techBlogArticle.getThumbnailImageUrl(),
                                techBlogArticle.getSourceUrl(),
                                techBlogArticle.getSourceFrom(),
                                techBlogArticle.getPublishedAt()
                        )).toList());
    }

//    public List<ReadTechBlogDto> readTechBlogList() {
//
//    }
}
