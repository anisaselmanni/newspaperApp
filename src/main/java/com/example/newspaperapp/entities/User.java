package com.example.newspaperapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 50)
    private Role role;

    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("1")
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    private Instant createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Journalist journalist;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Column(name = "updated_At")
    private Instant updatedAt;
}
