package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;

public interface BlobService {
    Blob saveBlobInformation(BlobCreate blobCreate, String username, String blobMetadataId, String expirationId);
}
