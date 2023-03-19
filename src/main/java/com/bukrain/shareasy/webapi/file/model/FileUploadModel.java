package com.bukrain.shareasy.webapi.file.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Getter
@RequiredArgsConstructor
public class FileUploadModel extends RepresentationModel<FileUploadModel> {
    private final String id;
}
