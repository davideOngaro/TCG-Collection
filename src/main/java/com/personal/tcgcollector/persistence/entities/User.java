package com.personal.tcgcollector.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="000_USER")
public class User {

    @Id
    private String userId;

    private String nickname;

    private String password;

    private String email;
}
