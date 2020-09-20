package com.Schelper.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //@MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity를 상속할경우 createDate, modifiedDate도 컬럼으로 인식한다.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate //@CreateDate : Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
