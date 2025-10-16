package com.apape.miledev.core.domain.article;

import com.apape.miledev.core.domain.common.BaseEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ARTICLE_TYPE")
@SuperBuilder
@Getter
@Setter(AccessLevel.PROTECTED)
@Entity
@NoArgsConstructor
public abstract class Article extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String thumbnailImageUrl;

    private Long viewCount;
}
