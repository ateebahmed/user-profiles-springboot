package com.ateebahmed.showcase.userprofiles.app.features.basicinfo;

import lombok.Value;

@Value
public class AddressModel {

    String houseNumber;
    String streetNumber;
    String area;
    String city;
    String province;
    String country;
}
