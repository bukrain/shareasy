package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.query.entity.blob.BlobMetadata;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;

public interface BlobService {
    BlobMetadata saveBlobMetadata(BlobCreate blobCreate);
    Blob saveBlobInformation(BlobCreate blobCreate, String username, String blobMetadataId);
}
