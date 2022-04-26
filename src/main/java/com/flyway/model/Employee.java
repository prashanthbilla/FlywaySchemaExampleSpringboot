package com.flyway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String mobile;
}
