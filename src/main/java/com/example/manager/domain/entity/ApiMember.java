package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import com.example.manager.domain.entity.project.ProjectApi;
import com.example.manager.domain.entity.project.ProjectMember;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "api_member")
public class ApiMember extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_member_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_api_num")
    private ProjectApi projectApi;

    @ManyToOne
    @JoinColumn(name = "member_num")
    private ProjectMember projectMember;

    // TODO: 담당 역할 코드번호
    // TODO: 참여 상태 코드번호
}