package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.AddUser;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.Address;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.Contact;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
public class AddUserTest {

    private AddUser addUser;

    @BeforeEach
    void setup() {
        this.addUser = new AddUser();
    }

    @Test
    public void createNewUser() {
        final var user = addUser.createNewUser(createFakeUser());

        Assertions.assertEquals("First", user.getFirstName());
        Assertions.assertEquals("Last", user.getLastName());
        Assertions.assertEquals(1, user.getAddresses()
                .size());
        Assertions.assertEquals(1, user.getContacts()
                .size());
    }

    @Test
    public void throwExceptionWhenUserFirstOrLastNamesAreEmpty() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> addUser
                .createNewUser(new User("", "", Collections.emptyList(), Collections.emptyList())));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void userMustHaveAnAddressAndContact() {
        final var user = addUser.createNewUser(createFakeUser());

        Assertions.assertEquals("First", user.getFirstName());
        Assertions.assertEquals("Last", user.getLastName());
        Assertions.assertEquals(1, user.getAddresses()
                .size());
        Assertions.assertEquals(1, user.getContacts()
                .size());
    }

    @Test
    public void throwExceptionWhenAddressOrContactIsEmpty() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                addUser.createNewUser(new User("First", "Last", Collections.emptyList(),
                        Collections.emptyList())));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void throwExceptionWhenAddressFieldsAreEmpty() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                addUser.createNewUser(new User("First", "Last",
                        Collections.singletonList(new Address("", "", "", "",
                                "", "")),
                        Collections.singletonList(new Contact("ateeb_ahmed33@outlook.com",
                                "+923354733833")))));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void throwExceptionWhenContactEmailIsBlank() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                addUser.createNewUser(new User("First", "Last",
                        Collections.singletonList(new Address("246", "21",
                                "Manzoor Colony", "Karachi", "Sindh", "Pakistan")),
                        Collections.singletonList(new Contact("", "")))));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    private User createFakeUser() {
        return new User("First", "Last",
                Collections.singletonList(new Address("246", "21", "Manzoor Colony",
                        "Karachi", "Sindh", "Pakistan")),
                Collections.singletonList(new Contact("ateeb_ahmed33@outlook.com",
                        "+923354733833")));
    }
}
