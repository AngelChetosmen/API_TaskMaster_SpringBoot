package com.taskmaster.euva.taskmaster.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name; 
    // Ej: "ROLE_USER", "ROLE_ADMIN"

    public Role(String name) {
        this.name = name;
    }
}