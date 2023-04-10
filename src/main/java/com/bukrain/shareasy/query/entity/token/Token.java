package com.bukrain.shareasy.query.entity.token;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.blob.Blob;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "token")
@NoArgsConstructor
@Getter
@Setter
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blob_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Blob blob;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expiration_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Expiration expiration;
    private String url;
    private String password;
    private String salt;
}
