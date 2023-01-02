package com.example.manager.domain.entity.service;

import com.example.manager.domain.entity.StringValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "service_item_value_hist")
public class ServiceItemValueHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hist_num")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_value_num")
    private ServiceItemValue serviceItemValue;

    // TODO: 항목값 (문자열 번호)
    // TODO: 항목값 (숫자)

    @ManyToOne
    @JoinColumn(name = "string_num")
    private StringValue stringValue;

    @CreatedDate
    @Column(name = "reg_date")
    protected LocalDateTime createdAt;
}
