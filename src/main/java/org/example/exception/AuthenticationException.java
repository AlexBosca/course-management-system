package org.example.exception;

public class AuthenticationException extends Exception {
    private final String title;

    public AuthenticationException(String message, String title) {
        super(message);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
