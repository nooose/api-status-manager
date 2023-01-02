package com.example.manager.domain.entity;

import com.example.manager.domain.entity.service.ServiceItemValueHistory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "string_value")
public class StringValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_num")
    private Integer id;

    @Column(name = "string_value")
    private String value;

    @CreatedDate
    @Column(name = "reg_date")
    protected LocalDateTime createdAt;

    @OneToMany
    private List<ServiceItemValueHistory> serviceItemValueHistories;
}
