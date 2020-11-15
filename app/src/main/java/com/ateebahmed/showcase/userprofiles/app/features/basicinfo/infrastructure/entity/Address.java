package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id @GeneratedValue private Long id;
    @Column(nullable = false) private String houseNumber;
    @Column(nullable = false) private String streetNumber;
    @Column(nullable = false) private String area;
    @Column(nullable = false) private String city;
    @Column(nullable = false) private String province;
    @Column(nullable = false) private String country;
    @ManyToOne(fetch = FetchType.LAZY) private User user;
}
