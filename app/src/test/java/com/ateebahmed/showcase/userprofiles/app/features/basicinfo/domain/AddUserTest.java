package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.domain;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.AddressModel;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.ContactModel;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.UserModel;
import lombok.val;
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
        val user = addUser.createNewUser(new UserModel("First", "Last",
                Collections.emptyList(), Collections.emptyList()));

        Assertions.assertEquals("First", user.getFirstName());
        Assertions.assertEquals("Last", user.getLastName());
        Assertions.assertEquals(0, user.getAddresses()
                .size());
        Assertions.assertEquals(0, user.getContacts()
                .size());
    }

    @Test
    public void throwExceptionWhenUserFirstOrLastNamesAreEmpty() {
        val exception = Assertions.assertThrows(IllegalArgumentException.class, () -> addUser
                .createNewUser(new UserModel("", "", Collections.emptyList(), Collections.emptyList())));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void userMustHaveAnAddressAndContact() {
        val user = addUser.createNewUser(createFakeUser());

        Assertions.assertEquals("First", user.getFirstName());
        Assertions.assertEquals("Last", user.getLastName());
        Assertions.assertEquals(1, user.getAddresses()
                .size());
        Assertions.assertEquals(1, user.getContacts()
                .size());
    }

    @Test
    public void throwExceptionWhenAddressOrContactIsEmpty() {
        val exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                addUser.createNewUser(new UserModel("First", "Last", Collections.emptyList(),
                        Collections.emptyList())));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void throwExceptionWhenAddressFieldsAreEmpty() {
        val exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                addUser.createNewUser(new UserModel("First", "Last",
                        Collections.singletonList(new AddressModel("", "", "", "",
                                "", "")),
                        Collections.singletonList(new ContactModel("ateeb_ahmed33@outlook.com",
                                "+923354733833")))));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void throwExceptionWhenContactEmailIsBlank() {
        val exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                addUser.createNewUser(new UserModel("First", "Last",
                        Collections.singletonList(new AddressModel("246", "21",
                                "Manzoor Colony", "Karachi", "Sindh", "Pakistan")),
                        Collections.singletonList(new ContactModel("", "")))));

        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    private UserModel createFakeUser() {
        return new UserModel("First", "Last",
                Collections.singletonList(new AddressModel("246", "21", "Manzoor Colony",
                        "Karachi", "Sindh", "Pakistan")),
                Collections.singletonList(new ContactModel("ateeb_ahmed33@outlook.com",
                        "+923354733833")));
    }
}
