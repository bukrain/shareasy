package com.bukrain.shareasy.blob.service;

import com.bukrain.shareasy.query.entity.file.File;
import com.bukrain.shareasy.webapi.file.dto.FileCreate;

public interface FileService {
    File saveFileInformation(FileCreate fileCreate, String username, String fileMetadataId, String expirationId);
}
