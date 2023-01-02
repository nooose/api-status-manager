package com.example.manager.domain.entity.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "project_join_dept")
public class ProjectJoinDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_dept_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "dept_num")
    private ProjectDepartment projectDepartment;

    @CreatedDate
    @Column(name = "reg_date")
    protected LocalDateTime createdAt;
}