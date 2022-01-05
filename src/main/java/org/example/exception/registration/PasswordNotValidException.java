package org.example.exception.registration;

public class PasswordNotValidException extends RegistrationException {  // TODO: Implement properly its method implementation
    public PasswordNotValidException() {
        super("Password isn't valid\nPassword should contain at least: one uppercase letter, one lowercase letter, one digit and should have at least 10 characters.", "Invalid Password");
    }
}
