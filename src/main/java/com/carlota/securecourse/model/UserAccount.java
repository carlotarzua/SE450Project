package com.carlota.securecourse.model;

import java.util.Objects;

public class UserAccount {
    private final long id;
    private final String name;
    private final String email;
    private final Role role;

    public UserAccount(long id, String name, String email, Role role) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.email = Objects.requireNonNull(email, "email cannot be null");
        this.role = Objects.requireNonNull(role, "role cannot be null");
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
