package com.example.testTask4.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.UUIDBinaryType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bank")
@Data
public class BankEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity id_client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_credit", nullable = false)
    private CreditEntity id_credit;
}
