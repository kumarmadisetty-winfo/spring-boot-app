package com.example.springbootdockercomposemysql.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user")
@Getter 
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    String name;
    
    @ManyToOne
    @JoinColumn(name="country",referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    Country country;

    
}
