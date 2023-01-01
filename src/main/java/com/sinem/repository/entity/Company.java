package com.sinem.repository.entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Table(name = "tblcompany")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String country;
    private String address;


}
