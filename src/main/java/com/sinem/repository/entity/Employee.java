package com.sinem.repository.entity;
import javax.persistence.*;

import com.sinem.repository.enums.EGender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Table(name = "tblemployee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String position;
    private int age;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;
}
