package com.example.manager.domain.entity.project;

import com.example.manager.domain.AuditingFields;
import com.example.manager.domain.entity.ApiMember;
import com.example.manager.domain.entity.service.MicroService;
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
@Table(name = "project_member")
public class ProjectMember extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dept_num")
    private ProjectDepartment department;

    @Column(name = "view_order")
    private int viewOrder;

    @Column(name = "member_name")
    private String name;

    // TODO: 참여자 구분 코드번호
    // TODO: 참여자 상태 코드번호

    @OneToMany(mappedBy = "projectMember")
    private List<ApiMember> apiMembers = new ArrayList<>();

    @OneToMany(mappedBy = "representativeMember")
    private List<MicroService> services = new ArrayList<>();
}
