package com.example.manager.domain.entity.service;

import com.example.manager.domain.AuditingFields;
import com.example.manager.domain.entity.Api;
import com.example.manager.domain.entity.project.ProjectMember;
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
import lombok.Getter;

@Getter
@Table(name = "service")
@Entity
public class MicroService extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_num")
    private Integer id;

    @Column(name = "service_name")
    private String name;
    @Column(name = "service_name_abbr")
    private String nameAbbr;
    @Column(name = "service_name_ko")
    private String nameKo;
    @Column(name = "view_order")
    private int viewOrder;
    @ManyToOne
    @JoinColumn(name = "member_num")
    private ProjectMember representativeMember;
    @Column(name = "code_repo")
    private String codeRepository;

    @OneToMany(mappedBy = "service")
    private List<ServiceItemValue> serviceItems = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<Api> apis = new ArrayList<>();
}
