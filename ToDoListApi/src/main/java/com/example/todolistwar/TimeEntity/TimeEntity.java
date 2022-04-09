package com.example.todolistwar.TimeEntity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalTime;

@MappedSuperclass //JPA Entitiy 클래스들이 이녀석을 상속하면, 클래스의 필드들이 칼럼으로 자동 인식되도록 함.
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class  TimeEntity {

    @CreatedDate
    private LocalTime PostTime;

    @LastModifiedDate
    private LocalTime ModityTime;

}
