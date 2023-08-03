package com.example.dtodemo.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    
    // Entity가 생성 되어 저장 될 때 시간 자동 저장
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;
 
    // Entity의 값이 변경 될 때 시간 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
