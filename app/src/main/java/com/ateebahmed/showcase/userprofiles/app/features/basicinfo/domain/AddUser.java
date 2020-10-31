package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.domain;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.UserModel;
import org.apache.logging.log4j.util.Strings;

public final class AddUser {

    public UserModel createNewUser(final UserModel user) {
        if (Strings.isBlank(user.getFirstName()) && Strings.isBlank(user.getLastName()))
            throw new IllegalArgumentException("User's first name and last name must not be blank");
        return user;
    }
}
