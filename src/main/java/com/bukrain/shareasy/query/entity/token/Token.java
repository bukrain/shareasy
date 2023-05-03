package com.bukrain.shareasy.query.entity.token;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.blob.Blob;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return id.equals(token.id) && Objects.equals(blob, token.blob) && Objects.equals(expiration, token.expiration) && Objects.equals(url, token.url) && Objects.equals(password, token.password) && Objects.equals(salt, token.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blob, expiration, url, password, salt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", blob=" + blob +
                ", expiration=" + expiration +
                ", url='" + url + '\'' +
                '}';
    }
}
