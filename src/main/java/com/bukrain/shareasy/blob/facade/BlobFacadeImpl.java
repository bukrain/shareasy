package com.bukrain.shareasy.blob.facade;

import com.bukrain.shareasy.blob.service.BlobService;
import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.webapi.blob.model.BlobModel;
import com.bukrain.shareasy.webapi.blob.model.BlobToBlobModelConverter;

public class BlobFacadeImpl implements BlobFacade {

    private final BlobToBlobModelConverter blobToBlobModelConverter;
    private final BlobService blobService;

    public BlobFacadeImpl(BlobToBlobModelConverter blobToBlobModelConverter, BlobService blobService) {
        this.blobToBlobModelConverter = blobToBlobModelConverter;
        this.blobService = blobService;
    }

    public BlobModel create(Blob blob) {

        return null;
    }
}
