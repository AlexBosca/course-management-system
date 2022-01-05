package org.example.exception.registration;

public class UnmatchedPasswordsException extends RegistrationException {

    public UnmatchedPasswordsException() {
        super("Passwords does not match!\nPlease try to reintroduce them.", "Unmatched Passwords");
    }
}
