package com.example.manager.domain.entity.project;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "project_dept")
public class ProjectDepartment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_num")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "parent_num")
    private ProjectDepartment parent;

    @Column(name = "depth_level")
    private int depthLevel;

    @Column(name = "view_order")
    private int viewOrder;

    @Column(name = "dept_name")
    private String name;

    @Column(name = "dept_desc")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<ProjectMember> members = new ArrayList<>();

    @OneToMany(mappedBy = "projectDepartment")
    private List<ProjectJoinDepartment> projectJoinDepartments = new ArrayList<>();
}