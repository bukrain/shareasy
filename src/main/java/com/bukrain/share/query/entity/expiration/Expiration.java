package com.bukrain.share.query.entity.expiration;

import com.bukrain.share.file.ExpirationType;
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
    private Instant expire;
    private int useCount;
    private boolean expired;
}
