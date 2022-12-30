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
public class ServiceItem extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_num")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "parent_num")
    private ServiceItem parent;

    @Column(name = "depth_level")
    private int depthLevel;

    @Column(name = "view_order")
    private int viewOrder;

    @Column(name = "item_id")
    private String itemId;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_desc")
    private String description;
}
