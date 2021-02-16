package com.example.testTask4.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "credit_offers")
@Data
public class CreditOfferEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_credit", nullable = false)
    private CreditEntity credit;
    @Column(name = "credit_sum")
    private int creditSum;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_credit_offer")
//    private List<PlanEntity> plans;
}
