package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class ProjectMember extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dept_num")
    private ProjectDepartment department;

    @OneToMany(mappedBy = "representativeMember")
    private List<MicroService> services = new ArrayList<>();

    @Column(name = "view_order")
    private int viewOrder;

    @Column(name = "member_name")
    private String name;
}
