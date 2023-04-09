package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.file.File;
import com.bukrain.shareasy.query.entity.file.FileMetadata;
import com.bukrain.shareasy.query.entity.user.User;
import com.bukrain.shareasy.query.repository.file.FileRepository;
import com.bukrain.shareasy.webapi.file.dto.FileCreate;
import com.fasterxml.uuid.Generators;

import java.time.Instant;
import java.util.ArrayList;

public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File saveFileInformation(FileCreate fileCreate, String username, String fileMetadataId, String expirationId) {
        User user = new User();
        user.setUsername(username);

        String fileId = Generators.timeBasedEpochGenerator().generate().toString();

        FileMetadata fileMetadata = new FileMetadata();
        fileMetadata.setId(fileMetadataId);

        Expiration expiration = new Expiration();
        expiration.setId(expirationId);

        File file = new File();
        file.setId(fileId);
        file.setUserId(user);
        file.setStoragePath(getFileStoragePath(username, fileId));
        file.setUploadDate(Instant.now());
        file.setExpiration(expiration);
        file.setTokens(new ArrayList<>());

        return fileRepository.save(file);
    }

    private String getFileStoragePath(String username, String fileId) {
        return String.format("%s/%s", username, fileId);
    }
}
