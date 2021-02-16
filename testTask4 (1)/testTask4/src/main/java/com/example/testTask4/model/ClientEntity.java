package com.example.testTask4.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    private String email;
    @Column(nullable = false)
    private String passport;


}
