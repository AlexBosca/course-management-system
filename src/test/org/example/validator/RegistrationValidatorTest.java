package org.example.validator;

import org.example.exception.registration.UnmatchedPasswordsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationValidatorTest {
    private final RegistrationValidator registrationValidator = new RegistrationValidator();

    @Test
    void validateEmail() {

    }

    @Test
    void validatePassword() {
    }

    @Test
    void validateName() {
    }

    @Test
    void validatePhoneNumber() {
    }

    @Test
    void validatePasswordsMatching() {
        String password = "SomePa$$w0rd";
        String retypedPassword = "SomePa$$w0rd";

        assertDoesNotThrow(() -> registrationValidator.validatePasswordsMatching(password, retypedPassword));
    }

    @Test
    void validatePasswordsNotMatching() {
        String password = "SomePa$$w0rd";
        String retypedPassword = "SomePa$w0rd";

        assertThrows(UnmatchedPasswordsException.class, () -> registrationValidator.validatePasswordsMatching(password, retypedPassword));
    }
}