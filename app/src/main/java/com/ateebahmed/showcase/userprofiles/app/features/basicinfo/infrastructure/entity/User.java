package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id @GeneratedValue private Long id;
    @Column(nullable = false) private String firstName;
    @Column(nullable = false) private String lastName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) private List<Address> addresses;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) private List<Contact> contacts;
}
