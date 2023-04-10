package com.bukrain.shareasy.webapi.blob;

import com.bukrain.shareasy.blob.ExpirationType;
import com.bukrain.shareasy.blob.facade.BlobFacade;
import com.bukrain.shareasy.webapi.blob.dto.*;
import com.bukrain.shareasy.webapi.blob.model.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping(path = "/api/v1/blobs")
public class BlobController {

    private final BlobFacade blobFacade;
    public BlobController(BlobFacade blobFacade) {
        this.blobFacade = blobFacade;
    }

    @GetMapping()
    public CollectionModel<BlobModel> getBlobs() {

        Collection<BlobModel> blobs = Collections.singleton(new BlobModel(
                "id",
                "blobName",
                Instant.now(),
                false,
                ExpirationType.SINGLE_USE,
                1024,
                "pathToBlob",
                Instant.now()
        ));
        return CollectionModel.of(blobs).withFallbackType(BlobModel.class);
    }

    @PostMapping()
    public BlobModel createBlob(@RequestBody BlobCreate blobCreate, Authentication authentication) {
        return new BlobModel(
                "id",
                "blobName",
                Instant.now(),
                false,
                ExpirationType.SINGLE_USE,
                1024,
                "pathToBlob",
                Instant.now()
        );
    }

    @GetMapping("/{blobId}")
    public BlobModel getBlob(@PathVariable String blobId) {
        return new BlobModel(
                "id",
                "blobName",
                Instant.now(),
                false,
                ExpirationType.SINGLE_USE,
                1024,
                "pathToBlob",
                Instant.now()
        );
    }

    @DeleteMapping("/{blobId}")
    public ResponseEntity<Void> deleteBlob(@PathVariable String blobId) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{blobId}")
    public BlobUpdateModel updateBlob(@PathVariable String blobId, @RequestBody BlobUpdate blobUpdate) {
        return new BlobUpdateModel("id", ExpirationType.TIME_BASED, 3600);
    }

    @GetMapping("/{blobId}/tokens")
    public CollectionModel<TokenModel> getTokens(@PathVariable String blobId) {
        Collection<TokenModel> tokenModel = Collections.singleton(new TokenModel(
                "id",
                3600,
                false,
                ExpirationType.TIME_BASED
        ));
        return CollectionModel.of(tokenModel).withFallbackType(TokenModel.class);
    }

    @PostMapping("/{blobId}/tokens")
    public TokenModel createToken(@PathVariable String blobId, @RequestBody TokenCreate tokenCreate) {
        return new TokenModel(
                "id",
                3600,
                false,
                ExpirationType.TIME_BASED
        );
    }

    @GetMapping("/{blobId}/tokens/{tokenId}")
    public TokenModel getToken(@PathVariable String blobId, @PathVariable String tokenId) {
        return new TokenModel(
                "id",
                3600,
                false,
                ExpirationType.TIME_BASED
        );
    }

    @DeleteMapping("/{blobId}/tokens/{tokenId}")
    public ResponseEntity<Void> deleteToken(@PathVariable String blobId, @PathVariable String tokenId) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{blobId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BlobUploadModel uploadBlob(
            @PathVariable String blobId,
            @RequestParam("chunkIndex") int chunkIndex,
            @RequestParam("blob") MultipartFile blob) {
        return new BlobUploadModel("id");
    }

    @PostMapping(value = "/{blobId}/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] downloadBlob(
            @PathVariable String blobId,
            @RequestParam("chunkStartIndex") int chunkStartIndex,
            @RequestParam("token") String token) {
        return new byte[0];
    }
}
