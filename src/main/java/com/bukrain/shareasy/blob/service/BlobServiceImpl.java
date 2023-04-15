package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.query.entity.blob.BlobMetadata;
import com.bukrain.shareasy.query.entity.user.User;
import com.bukrain.shareasy.query.repository.blob.BlobMetadataRepository;
import com.bukrain.shareasy.query.repository.blob.BlobRepository;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;
import com.fasterxml.uuid.Generators;

import java.time.Instant;
import java.util.ArrayList;

public class BlobServiceImpl implements BlobService {

    private final BlobRepository blobRepository;
    private final BlobMetadataRepository blobMetadataRepository;

    public BlobServiceImpl(BlobRepository blobRepository, BlobMetadataRepository blobMetadataRepository) {
        this.blobRepository = blobRepository;
        this.blobMetadataRepository = blobMetadataRepository;
    }
    @Override
    public BlobMetadata saveBlobMetadata(BlobCreate blobCreate) {
        BlobMetadata metadata = new BlobMetadata();
        metadata.setId(Generators.timeBasedEpochGenerator().generate().toString());
        metadata.setName(blobCreate.name());
        metadata.setSize(blobCreate.size());
        return blobMetadataRepository.save(metadata);
    }

    @Override
    public Blob saveBlobInformation(BlobCreate blobCreate, String username, String blobMetadataId, String expirationId) {
        User user = new User();
        user.setUsername(username);

        String blobId = Generators.timeBasedEpochGenerator().generate().toString();

        BlobMetadata blobMetadata = new BlobMetadata();
        blobMetadata.setId(blobMetadataId);

        Expiration expiration = new Expiration();
        expiration.setId(expirationId);

        Blob blob = new Blob();
        blob.setId(blobId);
        blob.setUserId(user);
        blob.setStoragePath(getBlobStoragePath(username, blobId));
        blob.setUploadDate(Instant.now());
        blob.setExpiration(expiration);
        blob.setTokens(new ArrayList<>());

        return blobRepository.save(blob);
    }

    private String getBlobStoragePath(String username, String blobId) {
        return String.format("%s/%s", username, blobId);
    }
}
