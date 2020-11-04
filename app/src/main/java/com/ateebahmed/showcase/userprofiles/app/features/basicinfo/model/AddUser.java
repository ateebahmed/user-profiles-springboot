package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;
import java.util.function.Predicate;

public final class AddUser {

    private final Predicate<User> userFirstLastNameAreBlank = user ->
            Strings.isBlank(user.getFirstName()) || Strings.isBlank(user.getLastName());

    private final Predicate<User> userAddressContactAreEmpty = user ->
            (Objects.isNull(user.getAddresses()) || user.getAddresses().isEmpty())
                    || (Objects.isNull(user.getContacts()) || user.getContacts().isEmpty());

    private final Predicate<Address> addressFieldsAreBlank = address -> Strings.isBlank(address.getArea())
            && Strings.isBlank(address.getCity()) && Strings.isBlank(address.getCountry())
            && Strings.isBlank(address.getCountry()) && Strings.isBlank(address.getHouseNumber())
            && Strings.isBlank(address.getProvince()) && Strings.isBlank(address.getStreetNumber());

    private final Predicate<Contact> contactEmailIsBlank = contact -> Strings.isBlank(contact.getEmail());

    public User createNewUser(final User user) {
        if (userFirstLastNameAreBlank.test(user))
            throw new IllegalArgumentException("User's first name and last name must not be blank");
        if (userAddressContactAreEmpty.test(user))
            throw new IllegalArgumentException("User's address and contact have at least one entry");

        final var address = user.getAddresses()
                .stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("User's address must have at least one entry"));
        if (addressFieldsAreBlank.test(address))
            throw new IllegalArgumentException("User's address fields must not be blank");

        final var contact = user.getContacts()
                .stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("User's contact must have one entry"));
        if (contactEmailIsBlank.test(contact)) throw new IllegalArgumentException("User's email must be present");

        return user;
    }
}
