package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Contact {

    @Id @GeneratedValue private Long id;
    @Column(nullable = false) private String email;
    @Column private String phone;
    @ManyToOne(fetch = FetchType.LAZY) private User user;
}
