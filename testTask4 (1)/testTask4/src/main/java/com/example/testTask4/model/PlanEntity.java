package com.example.testTask4.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "plans")
@Data
public class PlanEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_credit_offer", nullable = false)
    private  CreditOfferEntity creditOffer;
    @Column(nullable = false)
    private Date date;
    @Column(name = "total_sum", nullable = false)
    private BigDecimal totalSum;
    @Column(name = "credit_body_sum", nullable = false)
    private BigDecimal creditBodySum;
    @Column(name = "percent_body_sum", nullable = false)
    private BigDecimal percentBodySum;
}
