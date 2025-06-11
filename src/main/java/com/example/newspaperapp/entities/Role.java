package com.example.newspaperapp.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.newspaperapp.entities.Permission.*;


public enum Role {

    // ADMIN can access everything
    ADMIN(Set.of(
        ADMIN_READ,
        ADMIN_WRITE,
        JOURNALIST_READ,
        JOURNALIST_WRITE,
        READER_READ,
        READER_COMMENT
    )),

    // JOURNALIST can read and write articles, and comment
    JOURNALIST(Set.of(
        JOURNALIST_READ,
        JOURNALIST_WRITE,
        READER_READ,
        READER_COMMENT
    )),

    // READER can only read and comment
    READER(Set.of(
        READER_READ,
        READER_COMMENT
    ));

      Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        // Spring Security expects roles to start with "ROLE_"
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
