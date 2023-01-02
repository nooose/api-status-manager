package com.example.manager.domain.entity.project;

import com.example.manager.domain.AuditingFields;
import com.example.manager.domain.entity.Api;
import com.example.manager.domain.entity.ApiMember;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "project_api")
public class ProjectApi extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_api_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "api_num")
    private Api api;

    @Column(name = "requirement_id")
    private String requirementId;
    @Column(name = "requirement_desc")
    private String requirementDescription;

    // TODO: API 상태 코드번호

    @OneToMany(mappedBy = "projectApi")
    private List<ApiMember> apiMembers = new ArrayList<>();
}