package org.example.exception.login;

import org.example.exception.AuthenticationException;

public class LoginException extends AuthenticationException {
    public LoginException() {
        super("Doesn't exists any account with introduced credentials or these credentials are wrong!\nPlease try to reintroduce them.", "Login Error");
    }
}
