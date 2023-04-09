package com.bukrain.shareasy.webapi.file.model;

import com.bukrain.shareasy.file.ExpirationType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
@Relation(collectionRelation = "files")
public class FileModel extends RepresentationModel<FileModel> {
    private final String id;
    private final String name;
    private final Instant uploadDate;
    private final boolean isMarkedForDeletion;
    private final ExpirationType expirationType;
    private final int size;
    private final String filePath;
    private final Instant expire;
}
