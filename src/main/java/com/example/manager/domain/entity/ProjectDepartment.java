package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class ProjectDepartment extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_num")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "parent_num")
    private ProjectDepartment parent;

    @OneToMany(mappedBy = "department")
    private List<ProjectMember> members = new ArrayList<>();

    @Column(name = "depth_level")
    private int depthLevel;

    @Column(name = "view_order")
    private int viewOrder;

    @Column(name = "dept_name")
    private String name;
    @Column(name = "dept_desc")
    private String description;
}
