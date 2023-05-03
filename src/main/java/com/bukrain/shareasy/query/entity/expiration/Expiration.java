package com.bukrain.shareasy.query.entity.expiration;

import com.bukrain.shareasy.expiration.ExpirationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expiration that = (Expiration) o;
        return useCount == that.useCount && isExpired == that.isExpired && id.equals(that.id) && expirationType == that.expirationType && Objects.equals(expireDate, that.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expirationType, expireDate, useCount, isExpired);
    }

    @Override
    public String toString() {
        return "Expiration{" +
                "id='" + id + '\'' +
                ", expirationType=" + expirationType +
                ", expireDate=" + expireDate +
                ", useCount=" + useCount +
                ", isExpired=" + isExpired +
                '}';
    }
}
