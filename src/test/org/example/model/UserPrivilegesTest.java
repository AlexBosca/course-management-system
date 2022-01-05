package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPrivilegesTest {

    @Test
    void shouldGetAccountTypeStudent() {
        UserPrivileges studentPrivileges = UserPrivileges.STUDENT;
        String actual = studentPrivileges.getAccountType();

        String expected = UserPrivileges.STUDENT.getAccountType();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAccountTypeInstructor() {
        UserPrivileges studentPrivileges = UserPrivileges.INSTRUCTOR;
        String actual = studentPrivileges.getAccountType();

        String expected = UserPrivileges.INSTRUCTOR.getAccountType();

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAccountTypeAdmin() {
        UserPrivileges studentPrivileges = UserPrivileges.ADMIN;
        String actual = studentPrivileges.getAccountType();

        String expected = UserPrivileges.ADMIN.getAccountType();

        assertEquals(expected, actual);
    }
}