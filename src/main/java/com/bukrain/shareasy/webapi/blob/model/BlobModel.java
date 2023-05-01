package com.bukrain.shareasy.webapi.blob.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
@Relation(collectionRelation = "blobs")
public class BlobModel extends RepresentationModel<BlobModel> {
    private final String id;
    private final String name;
    private final Instant uploadDate;
    private final boolean isDeleted;
    private final int size;
    private final String blobPath;
}
