package com.bukrain.shareasy.query.entity.blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "blob_metadata")
@NoArgsConstructor
@Getter
@Setter
public class BlobMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int size;
    private String name;
}