package com.pets.petsecommerce.model.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String fistName;
    @Column(name = "sobrenome")
    private String lastName;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "senha", nullable = false)
    private String password;
    @Column(name = "telefone")
    private String tel;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Role> roles; // 1 user | 2 admin

    public User(String fistName, String lastName, String email, String password, String tel, Set<Role> roles) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.roles = roles;
    }
}
