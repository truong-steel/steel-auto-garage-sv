package com.vti.steel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="emil", nullable = false)
    private String email;

    @Column(name="created_at",nullable = false , updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name ="updated_at", updatable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name="user_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false)
    )
    private Set<Role> roles;
}
