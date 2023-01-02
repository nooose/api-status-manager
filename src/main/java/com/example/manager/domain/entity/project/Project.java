package com.example.manager.domain.entity.project;

import com.example.manager.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "project")
public class Project extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_num")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "parent_num")
    private Project parent;

    @Column(name = "dept_level")
    private int depthLevel;
    @Column(name = "view_order")
    private int viewOrder;
    @Column(name = "project_name")
    private String name;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "last_hist_num")
    private ProjectStatusHistory lastStatusHistory;

    @Column(name = "project_desc")
    private String description;

    @OneToMany(mappedBy = "project")
    private List<ProjectStatusHistory> projectStatusHistories = new ArrayList<>();
}