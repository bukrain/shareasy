package com.bukrain.share.webapi.file;

import com.bukrain.share.ExpirationType;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping(path = "/api/v1")
public class FileController {

    @GetMapping("/files")
    public CollectionModel<FileModel> getFiles() {

        Collection<FileModel> files = Collections.singleton(new FileModel(
                UUID.randomUUID().toString(),
                "fileName",
                Instant.now(),
                false,
                ExpirationType.AFTER_DOWNLOAD,
                1024,
                "path-to-file",
                1,
                1,
                3600
        ));
        return CollectionModel.of(files);
    }
}
