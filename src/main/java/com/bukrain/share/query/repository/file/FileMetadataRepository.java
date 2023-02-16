package com.bukrain.share.query.repository.file;


import com.bukrain.share.query.entity.file.FileMetadata;
import org.springframework.data.repository.ListCrudRepository;

public interface FileMetadataRepository extends ListCrudRepository<FileMetadata, String> {
}
