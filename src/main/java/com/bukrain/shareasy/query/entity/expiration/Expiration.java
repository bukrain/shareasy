package com.bukrain.shareasy.query.entity.expiration;

import com.bukrain.shareasy.file.ExpirationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity(name = "expiration")
@NoArgsConstructor
@Getter
@Setter
public class Expiration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private ExpirationType expirationType;
    private Instant expireDate;
    private int useCount;
    private boolean isExpired;
}
