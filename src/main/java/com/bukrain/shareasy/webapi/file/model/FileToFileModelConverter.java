package com.bukrain.shareasy.webapi.file.model;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.entity.file.File;
import com.bukrain.shareasy.query.entity.file.FileMetadata;

public class FileToFileModelConverter {

    public FileModel convert(File file, FileMetadata fileMetadata, Expiration expiration) {
        return new FileModel(
                file.getId(),
                fileMetadata.getFileName(),
                file.getUploadDate(),
                file.getExpiration().isExpired(),
                expiration.getExpirationType(),
                fileMetadata.getSize(),
                null,
                expiration.getExpireDate()
        );
    }
}
