package com.example.manager.domain.entity.service;

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
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "service_item_value")
public class ServiceItemValue extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_value_num")
    private Integer id;

    // TODO: 실행환경 코드번호
    @ManyToOne
    @JoinColumn(name = "item_num")
    private ServiceItem serviceItem;

    @ManyToOne
    @JoinColumn(name = "service_num")
    private MicroService service;

    @ManyToOne
    @JoinColumn(name = "hist_num")
    private ServiceItemValueHistory lastHistory;

    @OneToMany(mappedBy = "serviceItemValue")
    private List<ServiceItemValueHistory> histories;
}
