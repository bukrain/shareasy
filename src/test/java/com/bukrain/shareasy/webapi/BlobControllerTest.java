package com.bukrain.shareasy.webapi;

import com.bukrain.shareasy.expiration.ExpirationType;
import com.bukrain.shareasy.blob.facade.BlobFacadeImpl;
import com.bukrain.shareasy.webapi.blob.BlobController;
import com.bukrain.shareasy.webapi.blob.dto.*;
import com.bukrain.shareasy.webapi.blob.model.BlobModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.Instant;

import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BlobController.class)
public class BlobControllerTest {
    
    private static final String USERNAME = "someUser";

    @MockBean
    @SuppressWarnings("unused")
    private BlobFacadeImpl blobFacade;
    
    @Autowired
    @SuppressWarnings("unused")
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @WithMockUser(USERNAME)
    @Test
    void getBlobssShouldReturnCollectionOfBlobModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/blobs")).andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.blobs[0].id").value("id"))
                .andExpect(jsonPath("$._embedded.blobs[0].name").value("blobName"))
                .andExpect(jsonPath("$._embedded.blobs[0].uploadDate").isNotEmpty())
                .andExpect(jsonPath("$._embedded.blobs[0].deleted").value(false))
                .andExpect(jsonPath("$._embedded.blobs[0].size").value(1024))
                .andExpect(jsonPath("$._embedded.blobs[0].blobPath").value("pathToBlob"));
    }

    @WithMockUser(USERNAME)
    @Test
    void createBlobShouldReturnInformationAboutCreatedBlob() throws Exception {
        BlobCreate blobCreate = new BlobCreate(
                "blobName", 1024
        );
        var blobModel = new BlobModel(
                "id",
                "blobName",
                Instant.now(),
                false,
                1024,
                "pathToBlob"
        );
        doReturn(blobModel).when(blobFacade).create(blobCreate, USERNAME);
        this.mockMvc.perform(post("/api/v1/blobs")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(blobCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.name").value("blobName"))
                .andExpect(jsonPath("$.uploadDate").isNotEmpty())
                .andExpect(jsonPath("$.deleted").value(false))
                .andExpect(jsonPath("$.size").value(1024))
                .andExpect(jsonPath("$.blobPath").value("pathToBlob"));
    }

    @WithMockUser(USERNAME)
    @Test
    void getBlobShouldReturnSingleBlobModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/blobs/id")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.name").value("blobName"))
                .andExpect(jsonPath("$.uploadDate").isNotEmpty())
                .andExpect(jsonPath("$.deleted").value(false))
                .andExpect(jsonPath("$.size").value(1024))
                .andExpect(jsonPath("$.blobPath").value("pathToBlob"));
    }

    @WithMockUser(USERNAME)
    @Test
    void deleteBlobShouldReturn204Status() throws Exception {
        this.mockMvc.perform(delete("/api/v1/blobs/id").with(csrf())).andExpect(status().isNoContent());
    }

    @WithMockUser(USERNAME)
    @Test
    void updateBlobShouldReturnUpdatedFields() throws Exception {
        BlobUpdate blobUpdate = new BlobUpdate(ExpirationType.TIME_BASED, 3600);
        this.mockMvc.perform(patch("/api/v1/blobs/id").with(csrf())
                        .content(objectMapper.writeValueAsString(blobUpdate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.expirationType").value("TIME_BASED"))
                .andExpect(jsonPath("$.expire").value(3600));
    }

    @WithMockUser(USERNAME)
    @Test
    void getTokensShouldReturnCollectionOfTokens() throws Exception {
        this.mockMvc.perform(get("/api/v1/blobs/blobId/tokens"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.tokens[0].id").value("id"))
                .andExpect(jsonPath("$._embedded.tokens[0].expire").value(3600))
                .andExpect(jsonPath("$._embedded.tokens[0].expired").value(false))
                .andExpect(jsonPath("$._embedded.tokens[0].expirationType").value("TIME_BASED"));
    }

    @WithMockUser(USERNAME)
    @Test
    void createTokenShouldReturnInformationAboutCreatedToken() throws Exception {
        TokenCreate tokenCreate = new TokenCreate(
                3600,
                ExpirationType.TIME_BASED
        );
        this.mockMvc.perform(post("/api/v1/blobs/blobId/tokens").with(csrf())
                        .content(objectMapper.writeValueAsString(tokenCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.expire").value(3600))
                .andExpect(jsonPath("$.expired").value(false))
                .andExpect(jsonPath("$.expirationType").value("TIME_BASED"));
    }

    @WithMockUser(USERNAME)
    @Test
    void getTokenShouldReturnSingleTokenModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/blobs/blobId/tokens/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.expire").value(3600))
                .andExpect(jsonPath("$.expired").value(false))
                .andExpect(jsonPath("$.expirationType").value("TIME_BASED"));
    }

    @WithMockUser(USERNAME)
    @Test
    void deleteTokenShouldReturn204Status() throws Exception {
        this.mockMvc.perform(delete("/api/v1/blobs/blobId/tokens/id").with(csrf()))
                .andExpect(status().isNoContent());
    }

    @WithMockUser(USERNAME)
    @Test
    void uploadBlobShouldReturnBlobUploadModel() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "blob",
                "test.txt",
                null,
                "Test".getBytes());
        this.mockMvc.perform(multipart("/api/v1/blobs/blobId/upload")
                        .file(multipartFile)
                        .param("chunkIndex", "0")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"));
    }

    @WithMockUser(USERNAME)
    @Test
    void downloadBlobShouldReturnBytesOfBlob() throws Exception {
        byte[] expectedBytes = new byte[0];
        this.mockMvc.perform(post("/api/v1/blobs/blobId/download")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("token", "dummyToken")
                        .param("chunkStartIndex", "0")
                        .with(csrf()))
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .andExpect(content().bytes(expectedBytes));
    }
}
