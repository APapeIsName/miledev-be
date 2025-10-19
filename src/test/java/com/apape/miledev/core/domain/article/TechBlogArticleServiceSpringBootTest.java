package com.apape.miledev.core.domain.article;

import com.apape.miledev.core.domain.article.dto.CreateTechBlogDto;
import com.apape.miledev.core.domain.article.dto.ReadTechBlogDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
@Component
class TechBlogArticleServiceSpringBootTest {

    @Autowired
    private TechBlogArticleService techBlogArticleService;

    @Test
    void createTest() {
        CreateTechBlogDto createTechBlogDto = techBlogArticleService.create(
                new CreateTechBlogDto(
                        List.of(
                                new CreateTechBlogDto.CreateTechBlogParam(
                                        "테스트",
                                        "https://toss.tech/article/payments-legacy-1",
                                        "https://toss.tech/article/payments-legacy-1",
                                        "토스",
                                        LocalDate.now()
                                )
                        )
                )
        );

        Assertions.assertEquals(1, createTechBlogDto.techBlogDtos().size());
    }

    @Test
    public void readTest() throws Exception {
        //given

        //when
        Page<ReadTechBlogDto> readTechBlogDtos = techBlogArticleService.readTechBlogList(0, 10);

        //then
        Assertions.assertEquals(211, readTechBlogDtos.getTotalElements());
        Assertions.assertEquals("20년 레거시를 넘어 미래를 준비하는 시스템 만들기", readTechBlogDtos.getContent().getFirst().title());

    }
}