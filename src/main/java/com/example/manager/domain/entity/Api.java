package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import com.example.manager.domain.entity.project.ProjectApi;
import com.example.manager.domain.entity.service.MicroService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "api")
public class Api extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_num")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "parent_num")
    private Api parent;

    @Column(name = "dept_level")
    private int depthLevel;

    @Column(name = "view_order")
    private int viewOrder;

    @ManyToOne
    @JoinColumn(name = "service_num")
    private MicroService service;

    // TODO: 메서드 코드번호
    @Column(name = "api_num")
    private String name;

    // TODO: API 분류 코드번호
    @Column(name = "api_desc")
    private String description;
    @Column(name = "external_system_cnt")
    private int externalSystemCount;
    @Column(name = "etc_desc")
    private String etcDescription;

    @OneToMany(mappedBy = "api")
    private List<ApiExternalSystem> apiExternalSystems = new ArrayList<>();

    @OneToMany(mappedBy = "api")
    private List<ApiTargetTable> apiTargetTables = new ArrayList<>();

    @OneToMany(mappedBy = "api")
    private List<ProjectApi> projectApis = new ArrayList<>();
}
