package com.bukrain.shareasy.query.entity.blob;

import com.bukrain.shareasy.query.entity.token.Token;
import com.bukrain.shareasy.query.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity(name = "blob")
@NoArgsConstructor
@Getter
@Setter
public class Blob {
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "username", nullable = false, updatable = false)
    private User userId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id", nullable = false, updatable = false)
    private BlobMetadata blobMetadata;
    private String storagePath;
    private Instant uploadDate;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "blob")
    private List<Token> tokens;
    private boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blob blob = (Blob) o;
        return isDeleted == blob.isDeleted && id.equals(blob.id) &&
                Objects.equals(userId, blob.userId) && Objects.equals(blobMetadata, blob.blobMetadata) &&
                storagePath.equals(blob.storagePath) && uploadDate.equals(blob.uploadDate) &&
                Objects.equals(tokens, blob.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, blobMetadata, storagePath, uploadDate, tokens, isDeleted);
    }

    @Override
    public String toString() {
        return "Blob{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", blobMetadata=" + blobMetadata +
                ", storagePath='" + storagePath + '\'' +
                ", uploadDate=" + uploadDate +
                ", tokens=" + tokens +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
