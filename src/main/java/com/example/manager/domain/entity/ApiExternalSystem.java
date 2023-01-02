package com.example.manager.domain.entity;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "api_external_system")
public class ApiExternalSystem extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_system_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "api_num")
    private Api api;

    @ManyToOne
    @JoinColumn(name = "system_num")
    private ExternalSystem externalSystem;

    // TODO: 조회 여부 코드번호
    // TODO: 처리 여부 코드번호
}
