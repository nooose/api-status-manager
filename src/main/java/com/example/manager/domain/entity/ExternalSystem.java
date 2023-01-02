package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "external_system")
public class ExternalSystem extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_num")
    private Integer id;

    @Column(name = "system_name")
    private String name;
    @Column(name = "system_desc")
    private String description;

    @OneToMany(mappedBy = "externalSystem")
    private List<ApiExternalSystem> apiExternalSystems = new ArrayList<>();
}
