package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.domain;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.AddressModel;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.ContactModel;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.UserModel;
import lombok.val;
import org.apache.logging.log4j.util.Strings;

import java.util.function.Predicate;

public final class AddUser {

    private final Predicate<UserModel> userFirstLastNameAreBlank = user ->
            Strings.isBlank(user.getFirstName()) && Strings.isBlank(user.getLastName());

    private final Predicate<UserModel> userAddressContactAreEmpty = user ->
            user.getAddresses().isEmpty() && user.getContacts().isEmpty();

    private final Predicate<AddressModel> addressFieldsAreBlank = address -> Strings.isBlank(address.getArea())
            && Strings.isBlank(address.getCity()) && Strings.isBlank(address.getCountry())
            && Strings.isBlank(address.getCountry()) && Strings.isBlank(address.getHouseNumber())
            && Strings.isBlank(address.getProvince()) && Strings.isBlank(address.getStreetNumber());

    private final Predicate<ContactModel> contactEmailIsBlank = contact -> Strings.isBlank(contact.getEmail());

    public UserModel createNewUser(final UserModel user) {
        if (userFirstLastNameAreBlank.test(user))
            throw new IllegalArgumentException("User's first name and last name must not be blank");
        if (userAddressContactAreEmpty.test(user))
            throw new IllegalArgumentException("User's address and contact have at least one entry");

        val address = user.getAddresses()
                .stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("User's address must have at least one entry"));
        if (addressFieldsAreBlank.test(address))
            throw new IllegalArgumentException("User's address fields must not be blank");

        val contact = user.getContacts()
                .stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("User's contact must have one entry"));
        if (contactEmailIsBlank.test(contact)) throw new IllegalArgumentException("User's email must be present");

        return user;
    }
}
