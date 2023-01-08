package com.bukrain.share.webapi.file;

import com.bukrain.share.file.ExpirationType;
import com.bukrain.share.token.TokenType;
import com.bukrain.share.webapi.file.dto.*;
import com.bukrain.share.webapi.file.model.FileModel;
import com.bukrain.share.webapi.file.model.FileUpdateModel;
import com.bukrain.share.webapi.file.model.FileUploadModel;
import com.bukrain.share.webapi.file.model.TokenModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping(path = "/api/v1/files")
public class FileController {

    @GetMapping()
    public CollectionModel<FileModel> getFiles() {

        Collection<FileModel> files = Collections.singleton(new FileModel(
                "id",
                "fileName",
                Instant.now(),
                false,
                ExpirationType.AFTER_DOWNLOAD,
                1024,
                "pathToFile",
                1,
                1,
                3600
        ));
        return CollectionModel.of(files).withFallbackType(FileModel.class);
    }

    @PostMapping()
    public FileModel createFile(@RequestBody FileCreate fileCreate) {
        return new FileModel(
                "id",
                "fileName",
                Instant.now(),
                false,
                ExpirationType.AFTER_DOWNLOAD,
                1024,
                "pathToFile",
                1,
                1,
                3600
        );
    }

    @GetMapping("/{fileId}")
    public FileModel getFile(@PathVariable String fileId) {
        return new FileModel(
                "id",
                "fileName",
                Instant.now(),
                false,
                ExpirationType.AFTER_DOWNLOAD,
                1024,
                "pathToFile",
                1,
                1,
                3600
        );
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable String fileId) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{fileId}")
    public FileUpdateModel updateFile(@PathVariable String fileId, @RequestBody FileUpdate fileUpdate) {
        return new FileUpdateModel("id", ExpirationType.TIME_BASED, 3600);
    }

    @GetMapping("/{fileId}/tokens")
    public CollectionModel<TokenModel> getTokens(@PathVariable String fileId) {
        Collection<TokenModel> tokenModel = Collections.singleton(new TokenModel(
                "id",
                3600,
                false,
                TokenType.TIME_BASED
        ));
        return CollectionModel.of(tokenModel).withFallbackType(TokenModel.class);
    }

    @PostMapping("/{fileId}/tokens")
    public TokenModel createToken(@PathVariable String fileId, @RequestBody TokenCreate tokenCreate) {
        return new TokenModel(
                "id",
                3600,
                false,
                TokenType.TIME_BASED
        );
    }

    @GetMapping("/{fileId}/tokens/{tokenId}")
    public TokenModel getToken(@PathVariable String fileId, @PathVariable String tokenId) {
        return new TokenModel(
                "id",
                3600,
                false,
                TokenType.TIME_BASED
        );
    }

    @DeleteMapping("/{fileId}/tokens/{tokenId}")
    public ResponseEntity<Void> deleteToken(@PathVariable String fileId, @PathVariable String tokenId) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{fileId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileUploadModel uploadFile(
            @PathVariable String fileId,
            @RequestParam("chunkIndex") int chunkIndex,
            @RequestParam("file") MultipartFile file) {
        return new FileUploadModel("id");
    }

    @PostMapping(value = "/{fileId}/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] downloadFile(
            @PathVariable String fileId,
            @RequestParam("chunkStartIndex") int chunkStartIndex,
            @RequestParam("token") String token) {
        return new byte[0];
    }
}
