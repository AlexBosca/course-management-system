package org.example.model;

import java.time.LocalDate;

public class User {

    private final String emailAddress;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String phoneNumber;
    private final char[] password;
    private final UserPrivileges privileges;

    private User(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
        this.privileges = builder.privileges;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public char[] getPassword() {
        return password;
    }

    public UserPrivileges getPrivileges() {
        return privileges;
    }

    public static class Builder {

        private final String emailAddress;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String phoneNumber;
        private char[] password;
        private UserPrivileges privileges;

        public Builder(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;

            return this;
        }

        public Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;

            return this;
        }

        public Builder withPassword(char[] password) {
            this.password = password;

            return this;
        }

        public Builder withPrivileges(UserPrivileges privileges) {
            this.privileges = privileges;

            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
