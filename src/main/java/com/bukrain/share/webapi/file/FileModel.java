package com.bukrain.share.webapi.file;

import com.bukrain.share.ExpirationType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
public class FileModel extends RepresentationModel<FileModel> {
    private final String id;
    private final String name;
    private final Instant uploadDate;
    private final boolean markedForDeletion;
    private final ExpirationType expirationType;
    private final int size;
    private final String filePath;
    private final int chunksCount;
    private final int chunksUploaded;
    private final Integer expire;
}
