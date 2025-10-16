package com.apape.miledev.core.domain.article;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Component
class TechBlogArticleSpringBootTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    @Rollback(false)
    public void create() throws Exception {
        //given
        TechBlogArticle techBlogArticle = TechBlogArticle.create(
                "테스트",
                "https://toss.tech/article/payments-legacy-1",
                15L,
                "https://toss.tech/article/payments-legacy-1",
                "토스"
        );

        //when
        articleRepository.save(techBlogArticle);

        //then
        Assertions.assertEquals("테스트", techBlogArticle.getTitle());

    }
}