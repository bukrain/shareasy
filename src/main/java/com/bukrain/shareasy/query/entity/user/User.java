package com.bukrain.shareasy.query.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String username;
    private String email;
    private String password;
    private String salt;
}
