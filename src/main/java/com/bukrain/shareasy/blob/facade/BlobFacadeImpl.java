package com.bukrain.shareasy.blob.facade;

import com.bukrain.shareasy.blob.service.BlobService;
import com.bukrain.shareasy.expiration.service.ExpirationService;
import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;
import com.bukrain.shareasy.webapi.blob.model.BlobModel;
import com.bukrain.shareasy.webapi.blob.model.BlobToBlobModelConverter;

public class BlobFacadeImpl implements BlobFacade {

    private final BlobToBlobModelConverter blobToBlobModelConverter;
    private final BlobService blobService;
    private final ExpirationService expirationService;

    public BlobFacadeImpl(
            BlobToBlobModelConverter blobToBlobModelConverter,
            BlobService blobService,
            ExpirationService expirationService) {
        this.blobToBlobModelConverter = blobToBlobModelConverter;
        this.blobService = blobService;
        this.expirationService = expirationService;
    }

    public BlobModel create(BlobCreate blobCreate, String username) {

        return null;
    }
}
