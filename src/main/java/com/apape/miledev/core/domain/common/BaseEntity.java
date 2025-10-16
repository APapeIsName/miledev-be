package com.apape.miledev.core.domain.common;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
public abstract class BaseEntity {

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
    public <T extends BaseEntity> T delete() {
        deletedAt = LocalDateTime.now();
        return (T) this;
    }

    @PrePersist
    public void onPersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
