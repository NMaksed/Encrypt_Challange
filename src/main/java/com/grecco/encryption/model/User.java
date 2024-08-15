package com.grecco.encryption.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userDocument", nullable = false)
    private String userDocument;
    @Column(name = "creditCardToken", nullable = false)
    private String creditCardToken;
    @Column(name = "value", nullable = false)
    private Long value;
}
