package com.bukrain.shareasy.query.entity.file;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "file_metadata")
@NoArgsConstructor
@Getter
@Setter
public class FileMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int size;
    private int chunksCount;
    private int chunksUploaded;
    private String filePath;
}
