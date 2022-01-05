package org.example.validator;

import org.example.exception.registration.*;

public class RegistrationValidator {
    public void validateEmail(String email) throws EmailNotValidException {
        if(!Validator.validateEmail(email)) {
            throw new EmailNotValidException();
        }
    }

    public void validatePassword(String password) throws PasswordNotValidException {
        if(!Validator.validatePassword(password)) {
            throw new PasswordNotValidException();
        }
    }

    public void validateName(String name) throws NameNotValidException {
        if(!Validator.validateName(name)) {
            throw new NameNotValidException();
        }
    }

    public void validatePhoneNumber(String phoneNumber) throws PhoneNumberNotValidException {
        if(!Validator.validatePhoneNumber(phoneNumber)) {
            throw new PhoneNumberNotValidException();
        }
    }

    public void validatePasswordsMatching(String password, String retypedPassword) throws UnmatchedPasswordsException {
        if(!Validator.validatePasswordsMatching(password, retypedPassword)) {
            throw new UnmatchedPasswordsException();
        }
    }
}
