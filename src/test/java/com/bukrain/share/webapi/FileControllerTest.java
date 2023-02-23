package com.bukrain.share.webapi;

import com.bukrain.share.file.ExpirationType;
import com.bukrain.share.webapi.file.FileController;
import com.bukrain.share.webapi.file.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FileController.class)
public class FileControllerTest {

    @Autowired
    @SuppressWarnings("unused")
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @WithMockUser
    @Test
    void getFilesShouldReturnCollectionOfFileModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/files")).andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.files[0].id").value("id"))
                .andExpect(jsonPath("$._embedded.files[0].name").value("fileName"))
                .andExpect(jsonPath("$._embedded.files[0].uploadDate").isNotEmpty())
                .andExpect(jsonPath("$._embedded.files[0].markedForDeletion").value(false))
                .andExpect(jsonPath("$._embedded.files[0].expirationType").value("SINGLE_USE"))
                .andExpect(jsonPath("$._embedded.files[0].size").value(1024))
                .andExpect(jsonPath("$._embedded.files[0].filePath").value("pathToFile"))
                .andExpect(jsonPath("$._embedded.files[0].chunksCount").value(1))
                .andExpect(jsonPath("$._embedded.files[0].chunksUploaded").value(1))
                .andExpect(jsonPath("$._embedded.files[0].expire").value(3600));
    }

    @WithMockUser
    @Test
    void createFileShouldReturnInformationAboutCreatedFile() throws Exception {
        FileCreate fileCreate = new FileCreate(
                "fileName", com.bukrain.share.file.ExpirationType.SINGLE_USE, 1024, 3600
        );
        this.mockMvc.perform(post("/api/v1/files")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(fileCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.name").value("fileName"))
                .andExpect(jsonPath("$.uploadDate").isNotEmpty())
                .andExpect(jsonPath("$.markedForDeletion").value(false))
                .andExpect(jsonPath("$.expirationType").value("SINGLE_USE"))
                .andExpect(jsonPath("$.size").value(1024))
                .andExpect(jsonPath("$.filePath").value("pathToFile"))
                .andExpect(jsonPath("$.chunksCount").value(1))
                .andExpect(jsonPath("$.chunksUploaded").value(1))
                .andExpect(jsonPath("$.expire").value(3600));
    }

    @WithMockUser
    @Test
    void getFileShouldReturnSingleFileModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/files/id")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.name").value("fileName"))
                .andExpect(jsonPath("$.uploadDate").isNotEmpty())
                .andExpect(jsonPath("$.markedForDeletion").value(false))
                .andExpect(jsonPath("$.expirationType").value("SINGLE_USE"))
                .andExpect(jsonPath("$.size").value(1024))
                .andExpect(jsonPath("$.filePath").value("pathToFile"))
                .andExpect(jsonPath("$.chunksCount").value(1))
                .andExpect(jsonPath("$.chunksUploaded").value(1))
                .andExpect(jsonPath("$.expire").value(3600));
    }

    @WithMockUser
    @Test
    void deleteFileShouldReturn204Status() throws Exception {
        this.mockMvc.perform(delete("/api/v1/files/id").with(csrf())).andExpect(status().isNoContent());
    }

    @WithMockUser
    @Test
    void updateFileShouldReturnUpdatedFields() throws Exception {
        FileUpdate fileUpdate = new FileUpdate(com.bukrain.share.file.ExpirationType.TIME_BASED, 3600);
        this.mockMvc.perform(patch("/api/v1/files/id").with(csrf())
                        .content(objectMapper.writeValueAsString(fileUpdate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.expirationType").value("TIME_BASED"))
                .andExpect(jsonPath("$.expire").value(3600));
    }

    @WithMockUser
    @Test
    void getTokensShouldReturnCollectionOfTokens() throws Exception {
        this.mockMvc.perform(get("/api/v1/files/fileId/tokens"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.tokens[0].id").value("id"))
                .andExpect(jsonPath("$._embedded.tokens[0].expire").value(3600))
                .andExpect(jsonPath("$._embedded.tokens[0].expired").value(false))
                .andExpect(jsonPath("$._embedded.tokens[0].tokenType").value("TIME_BASED"));
    }

    @WithMockUser
    @Test
    void createTokenShouldReturnInformationAboutCreatedToken() throws Exception {
        TokenCreate tokenCreate = new TokenCreate(
                3600,
                ExpirationType.TIME_BASED
        );
        this.mockMvc.perform(post("/api/v1/files/fileId/tokens").with(csrf())
                        .content(objectMapper.writeValueAsString(tokenCreate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.expire").value(3600))
                .andExpect(jsonPath("$.expired").value(false))
                .andExpect(jsonPath("$.tokenType").value("TIME_BASED"));
    }

    @WithMockUser
    @Test
    void getTokenShouldReturnSingleTokenModel() throws Exception {
        this.mockMvc.perform(get("/api/v1/files/fileId/tokens/id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.expire").value(3600))
                .andExpect(jsonPath("$.expired").value(false))
                .andExpect(jsonPath("$.tokenType").value("TIME_BASED"));
    }

    @WithMockUser
    @Test
    void deleteTokenShouldReturn204Status() throws Exception {
        this.mockMvc.perform(delete("/api/v1/files/fileId/tokens/id").with(csrf()))
                .andExpect(status().isNoContent());
    }

    @WithMockUser
    @Test
    void uploadFileShouldReturnFileUploadModel() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",
                "test.txt",
                null,
                "Test".getBytes());
        this.mockMvc.perform(multipart("/api/v1/files/fileId/upload")
                        .file(multipartFile)
                        .param("chunkIndex", "0")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"));
    }

    @WithMockUser
    @Test
    void downloadFileShouldReturnBytesOfFile() throws Exception {
        byte[] expectedBytes = new byte[0];
        this.mockMvc.perform(post("/api/v1/files/fileId/download")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("token", "dummyToken")
                        .param("chunkStartIndex", "0")
                        .with(csrf()))
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .andExpect(content().bytes(expectedBytes));
    }
}
