package com.bukrain.shareasy.query.entity.blob;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.token.Token;
import com.bukrain.shareasy.query.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

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

}
