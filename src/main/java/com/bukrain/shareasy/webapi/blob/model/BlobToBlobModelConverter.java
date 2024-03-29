package com.bukrain.shareasy.webapi.blob.model;

import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.query.entity.blob.BlobMetadata;

public class BlobToBlobModelConverter {

    public BlobModel convert(Blob blob, BlobMetadata blobMetadata) {
        return new BlobModel(
                blob.getId(),
                blobMetadata.getName(),
                blob.getUploadDate(),
                blob.isDeleted(),
                blobMetadata.getSize(),
                null
        );
    }
}
