package org.example.model;

public enum UserPrivileges {
    STUDENT("student"),
    INSTRUCTOR("instructor"),
    ADMIN("admin");

    private String accountType;

    UserPrivileges(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return this.accountType;
    }
}
