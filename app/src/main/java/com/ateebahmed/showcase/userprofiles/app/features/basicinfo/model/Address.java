package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model;

import lombok.Value;

@Value
public class Address {

    String houseNumber;
    String streetNumber;
    String area;
    String city;
    String province;
    String country;
}
