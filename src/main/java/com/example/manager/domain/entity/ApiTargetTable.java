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
@Table(name = "api_target_table")
public class ApiTargetTable extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_table_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "api_num")
    private Api api;

    @ManyToOne
    @JoinColumn(name = "table_num")
    private TargetTable table;

    // TODO: 조회 여부 코드번호
    // TODO: 생성 여부 코드번호
    // TODO: 수정 여부 코드번호
    // TODO: 삭제 여부 코드번호
}