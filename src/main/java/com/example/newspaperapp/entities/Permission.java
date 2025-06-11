package com.example.newspaperapp.entities;

import lombok.Getter;

public enum Permission {
    // Admin permissions
    ADMIN_READ("admin:read"),           // View users, articles, settings
    ADMIN_WRITE("admin:write"),         // Manage users, settings, full access

    // Journalist permissions
    JOURNALIST_READ("journalist:read"), // View drafts, assigned articles
    JOURNALIST_WRITE("journalist:write"), // Create/edit/delete drafts or articles

    // Reader permissions
    READER_READ("reader:read"),         // View published articles
    READER_COMMENT("reader:comment");   // Add comments

    @Getter
    private final String permission;

     Permission(String permission) {
        this.permission = permission;
    }
}
