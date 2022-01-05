package org.example.exception.registration;

public class EmailNotValidException extends RegistrationException { // TODO: Implement properly its method implementation
    public EmailNotValidException() {
        super("Email isn't valid!\nPlease reintroduce your email address.", "Invalid Email");
    }
}
