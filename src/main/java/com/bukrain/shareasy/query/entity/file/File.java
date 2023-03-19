package com.bukrain.shareasy.query.entity.file;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.token.Token;
import com.bukrain.shareasy.query.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity(name = "file")
@NoArgsConstructor
@Getter
@Setter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "username", nullable = false, updatable = false)
    private User userId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id", nullable = false, updatable = false)
    private FileMetadata fileMetadata;
    private String storagePath;
    private String fileName;
    private Instant uploadDate;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expiration_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Expiration expiration;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "file")
    private List<Token> tokens;

}
