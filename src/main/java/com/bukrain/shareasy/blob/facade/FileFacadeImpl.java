package com.bukrain.shareasy.blob.facade;

import com.bukrain.shareasy.blob.service.FileService;
import com.bukrain.shareasy.query.entity.file.File;
import com.bukrain.shareasy.webapi.file.model.FileModel;
import com.bukrain.shareasy.webapi.file.model.FileToFileModelConverter;

public class FileFacadeImpl implements FileFacade {

    private final FileToFileModelConverter fileToFileModelConverter;
    private final FileService fileService;

    public FileFacadeImpl(FileToFileModelConverter fileToFileModelConverter, FileService fileService) {
        this.fileToFileModelConverter = fileToFileModelConverter;
        this.fileService = fileService;
    }

    public FileModel create(File file) {

        return fileToFileModelConverter.convert(file);
    }
}
