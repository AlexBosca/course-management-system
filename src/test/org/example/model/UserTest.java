package org.example.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User userToTest;

    @BeforeEach
    void setUp() {
        userToTest = new User.Builder("firstname.lastname@email.com")
                .withFirstName("firstName")
                .withLastName("lastName")
                .withDateOfBirth(LocalDate.now())
                .withPhoneNumber("0741963842")
                .withPassword("pA$$word".toCharArray())
                .withPrivileges(UserPrivileges.STUDENT)
                .build();
    }

    @AfterEach
    void tearDown() {
        userToTest = null;
        assertNull(userToTest);
    }

    @Test
    void userShouldNotBeNull() {
        assertNotNull(userToTest);
    }

    @Test
    void getEmailAddress() {
        String actual = userToTest.getEmailAddress();

        String expected = "firstname.lastname@email.com";

        assertEquals(expected, actual);
    }

    @Test
    void getFirstName() {
        String actual = userToTest.getFirstName();

        String expected = "firstName";

        assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String actual = userToTest.getLastName();

        String expected = "lastName";

        assertEquals(expected, actual);
    }

    @Test
    void getDateOfBirth() {
        LocalDate actual = userToTest.getDateOfBirth();

        LocalDate expected = LocalDate.now();

        assertEquals(expected, actual);
    }

    @Test
    void getPhoneNumber() {
        String actual = userToTest.getPhoneNumber();

        String expected = "0741963842";

        assertEquals(expected, actual);
    }

    @Test
    void getPassword() {
        char[] actual = userToTest.getPassword();

        char[] expected = "pA$$word".toCharArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getPrivileges() {
        UserPrivileges actual = userToTest.getPrivileges();

        UserPrivileges expected = UserPrivileges.STUDENT;

        assertEquals(expected, actual);
    }
}