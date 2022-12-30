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
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class ServiceItemValue extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_value_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_num")
    private ServiceItem serviceItem;

    @ManyToOne
    @JoinColumn(name = "service_num")
    private MicroService service;

    @OneToMany(mappedBy = "serviceItemValue")
    private List<ServiceItemValueHistory> histories;
}
