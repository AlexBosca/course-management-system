package org.example.exception.registration;

import org.example.exception.AuthenticationException;

public class RegistrationException extends AuthenticationException {
    public RegistrationException(String message, String title) {
        super(message, title);
    }
}
