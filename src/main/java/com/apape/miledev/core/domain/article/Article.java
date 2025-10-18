package com.apape.miledev.core.domain.article;

import com.apape.miledev.core.domain.common.BaseEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ARTICLE_TYPE")
@SuperBuilder
@Getter
@Setter(AccessLevel.PROTECTED)
@Entity
@NoArgsConstructor
public abstract class Article {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String thumbnailImageUrl;

    private Long viewCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    /**
     * 오류 메시지 단순화용
     * @return entityName
     */
    public abstract String entityName();

    public boolean isDeleted() {
        return deletedAt != null;
    }

    /**
     * 삭제 및 해당 엔티티 정보 가져오기
     * @return T
     */
    @SuppressWarnings("unchecked")
    public <T extends Article> T delete() {
        deletedAt = LocalDateTime.now();
        return (T) this;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.viewCount = 0L;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
