package com.example.Task_311.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user1")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Integer id;

    @Column(name="age")
    Integer age;
    @Column(name="email")
    String email;
    @Column(name="firstname")
    String firstName;
    @Column(name="lastname")
    String lastName;


}
