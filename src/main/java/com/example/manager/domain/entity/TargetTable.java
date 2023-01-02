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
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "target_table")
public class TargetTable extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_num")
    private Integer id;

    @Column(name = "schema_name")
    private String schemaName;
    @Column(name = "table_name")
    private String tableName;

    @ManyToOne
    @JoinColumn(name = "hist_num")
    private TargetTableCountHistory lastHistory;


    // TODO: 파티셔닝 여부 코드번호
    // TODO: 정방향 동기화 여부 코드번호
    // TODO: 역방향 동기화 여부 코드번호

    @OneToMany(mappedBy = "targetTable")
    private List<TargetTableCountHistory> histories;

    @OneToMany(mappedBy = "targetTable")
    private List<TargetTableCountHistory> targetTableCountHistories = new ArrayList<>();
}