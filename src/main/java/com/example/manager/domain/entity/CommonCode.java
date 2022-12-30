package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
@Entity
public class CommonCode extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_num")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "parent_num")
    private CommonCode parent;

    @Column(name = "depth_level")
    private int depthLevel;

    @Column(name = "view_order")
    private int viewOrder;

    @Column(name = "code_id")
    private String codeId;
    @Column(name = "code_name")
    private String name;
    @Column(name = "code_description")
    private String description;
}
