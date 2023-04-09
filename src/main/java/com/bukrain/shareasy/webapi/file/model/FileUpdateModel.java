package com.bukrain.shareasy.webapi.file.model;

import com.bukrain.shareasy.blob.ExpirationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FileUpdateModel extends RepresentationModel<FileUpdateModel> {
    private final String id;
    private ExpirationType expirationType;
    private Integer expire;
}
