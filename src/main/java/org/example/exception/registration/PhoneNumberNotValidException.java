package org.example.exception.registration;

public class PhoneNumberNotValidException extends RegistrationException {
    public PhoneNumberNotValidException() {
        super("Phone number isn't valid!\nPlease try to reintroduce it.", "Invalid Phone Number");
    }
}
