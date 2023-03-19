package com.bukrain.shareasy.query.repository.file;


import com.bukrain.shareasy.query.entity.file.FileMetadata;
import org.springframework.data.repository.ListCrudRepository;

public interface FileMetadataRepository extends ListCrudRepository<FileMetadata, String> {
}
