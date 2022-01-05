package org.example.exception.registration;

public class NameNotValidException extends RegistrationException {
    public NameNotValidException() {
        super("Name isn't valid!\nPlease try to reintroduce it.", "Invalid Name");
    }
}
