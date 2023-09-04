package com.tridentz.boot.domain.company;

import com.tridentz.boot.domain.company.enums.CompanyType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private CompanyType type;
}