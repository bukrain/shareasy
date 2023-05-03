package com.bukrain.shareasy.blob.facade;

import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;
import com.bukrain.shareasy.webapi.blob.model.BlobModel;

public interface BlobFacade {

    BlobModel create(BlobCreate blobCreate, String username);
}
