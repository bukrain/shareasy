package com.bukrain.shareasy.query.repository.blob;

import com.bukrain.shareasy.query.entity.blob.Blob;
import org.springframework.data.repository.ListCrudRepository;

public interface BlobRepository extends ListCrudRepository<Blob, String> {
}
