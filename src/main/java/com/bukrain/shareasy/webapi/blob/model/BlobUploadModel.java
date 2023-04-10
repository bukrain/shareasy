package com.bukrain.shareasy.webapi.blob.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Getter
@RequiredArgsConstructor
public class BlobUploadModel extends RepresentationModel<BlobUploadModel> {
    private final String id;
}
