package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.helpers.id.IdGenerator;
import com.bukrain.shareasy.query.entity.blob.Blob;
import com.bukrain.shareasy.query.entity.blob.BlobMetadata;
import com.bukrain.shareasy.query.entity.user.User;
import com.bukrain.shareasy.query.repository.blob.BlobMetadataRepository;
import com.bukrain.shareasy.query.repository.blob.BlobRepository;
import com.bukrain.shareasy.webapi.blob.dto.BlobCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlobServiceImplTest {

    @Mock
    private BlobRepository blobRepository;
    @Mock
    private BlobMetadataRepository metadataRepository;
    @Mock
    private IdGenerator idGenerator;

    private BlobServiceImpl blobService;

    @BeforeEach
    void setUp(){
        blobService = new BlobServiceImpl(blobRepository, metadataRepository, idGenerator);
    }

    @Test
    void givenBlobCreate_whenSaveBlobMetadata_saveAndReturnMetadata(){
        var metadataId = "metadataId";
        var name = "fileName";
        int size = 1024;

        doAnswer(x -> x.getArguments()[0])
                .when(metadataRepository).save(any());

        doReturn(metadataId)
                .when(idGenerator)
                .generateId();

        var blobCreate = new BlobCreate(
                name,
                size
        );
        var expectedMetadata = new BlobMetadata();
        expectedMetadata.setId(metadataId);
        expectedMetadata.setName(name);
        expectedMetadata.setSize(size);

        var metadata = blobService.saveBlobMetadata(blobCreate);

        assertEquals(expectedMetadata, metadata);

    }

    @Test
    void givenBlobCreateUsernameMetadataId_whenSaveBlobInformation_saveAndReturnBlob(){
        doAnswer(x -> x.getArguments()[0])
                .when(blobRepository).save(any());

        var blobId = "blobId";
        var username = "user";
        var metadataId = "metadataId";
        var name = "fileName";
        var size = 1024;
        var uploadDate = Instant.now();

        doReturn(blobId)
                .when(idGenerator)
                .generateId();
        var user = new User();
        user.setUsername(username);

        var expectedBlob = new Blob();
        expectedBlob.setId(blobId);
        expectedBlob.setUserId(user);
        expectedBlob.setStoragePath("user/blobId");
        expectedBlob.setUploadDate(uploadDate);
        expectedBlob.setDeleted(false);
        expectedBlob.setTokens(new ArrayList<>());

        var blobCreate = new BlobCreate(
                name,
                size
        );

        try(MockedStatic<Instant> mockedStatic = mockStatic(Instant.class)) {
            mockedStatic.when(Instant::now).thenReturn(uploadDate);
            var blob = blobService.saveBlobInformation(blobCreate, username, metadataId);
            assertEquals(expectedBlob, blob);
        }
    }
}
