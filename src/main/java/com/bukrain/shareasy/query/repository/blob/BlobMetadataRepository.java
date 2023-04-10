package com.bukrain.shareasy.query.repository.blob;


import com.bukrain.shareasy.query.entity.blob.BlobMetadata;
import org.springframework.data.repository.ListCrudRepository;

public interface BlobMetadataRepository extends ListCrudRepository<BlobMetadata, String> {
}
