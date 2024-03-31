package org.vyvr.javaprojektzaliczeniowy.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String password;
    private String email;

    public User() {
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }


    public User(String name, String surname, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
}