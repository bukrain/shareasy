package com.bukrain.shareasy.blob.facade;

import com.bukrain.shareasy.blob.service.BlobService;
import com.bukrain.shareasy.expiration.service.ExpirationService;
import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.query.entity.blob.BlobMetadata;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;
import com.bukrain.shareasy.webapi.blob.model.BlobToBlobModelConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlobFacadeImplTest {

    private static final String USERNAME = "user";

    @Mock
    private BlobService blobService;
    @Mock
    private BlobToBlobModelConverter converter;
    @Mock
    private ExpirationService expirationService;

    private BlobFacadeImpl blobFacade;


    @BeforeEach
    void setUp(){
        blobFacade = new BlobFacadeImpl(converter, blobService, expirationService);
    }

    @Test
    void givenBlobCreateAndUsername_whenCreate_saveBlobInformationAndConvertBlob(){
        var metadata = new BlobMetadata();
        metadata.setSize(1024);
        metadata.setId("metadataId");
        metadata.setName("someName");

        var blob = new Blob();
        blob.setId("blobId");
        blob.setBlobMetadata(metadata);
        blob.setStoragePath("storagePath");
        blob.setUploadDate(Instant.now());
        blob.setDeleted(false);

        var blobCreate = new BlobCreate(
                "fileName",
                1024
        );

        doReturn(metadata).when(blobService).saveBlobMetadata(blobCreate);
        doReturn(blob).when(blobService).saveBlobInformation(blobCreate, USERNAME, metadata.getId());

        blobFacade.create(blobCreate, USERNAME);

        verify(blobService).saveBlobMetadata(blobCreate);
        verify(blobService).saveBlobInformation(blobCreate, USERNAME, metadata.getId());
        verify(converter).convert(blob, metadata);
    }

}
