package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.helpers.id.IdGenerator;
import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.query.entity.blob.BlobMetadata;
import com.bukrain.shareasy.query.entity.user.User;
import com.bukrain.shareasy.query.repository.blob.BlobMetadataRepository;
import com.bukrain.shareasy.query.repository.blob.BlobRepository;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;

import java.time.Instant;
import java.util.ArrayList;

public class BlobServiceImpl implements BlobService {

    private final BlobRepository blobRepository;
    private final BlobMetadataRepository blobMetadataRepository;
    private final IdGenerator idGenerator;

    public BlobServiceImpl(
            BlobRepository blobRepository,
            BlobMetadataRepository blobMetadataRepository,
            IdGenerator idGenerator
    ) {
        this.blobRepository = blobRepository;
        this.blobMetadataRepository = blobMetadataRepository;
        this.idGenerator = idGenerator;
    }
    @Override
    public BlobMetadata saveBlobMetadata(BlobCreate blobCreate) {
        BlobMetadata metadata = new BlobMetadata();
        metadata.setId(idGenerator.generateId());
        metadata.setName(blobCreate.name());
        metadata.setSize(blobCreate.size());
        return blobMetadataRepository.save(metadata);
    }

    @Override
    public Blob saveBlobInformation(BlobCreate blobCreate, String username, String blobMetadataId) {
        User user = new User();
        user.setUsername(username);

        String blobId = idGenerator.generateId();

        BlobMetadata blobMetadata = new BlobMetadata();
        blobMetadata.setId(blobMetadataId);

        Blob blob = new Blob();
        blob.setId(blobId);
        blob.setUserId(user);
        blob.setStoragePath(getBlobStoragePath(username, blobId));
        blob.setUploadDate(Instant.now());
        blob.setTokens(new ArrayList<>());
        blob.setDeleted(false);

        return blobRepository.save(blob);
    }

    private String getBlobStoragePath(String username, String blobId) {
        return String.format("%s/%s", username, blobId);
    }
}
