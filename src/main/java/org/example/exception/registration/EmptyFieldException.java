package org.example.exception.registration;

public class EmptyFieldException extends RegistrationException {    // TODO: Implement properly its method implementation and to refactor outside of this package
    public EmptyFieldException(String message, String title) {
        super(message, title);
    }
}
