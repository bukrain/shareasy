package com.bukrain.shareasy.webapi.blob.model;

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
public class BlobUpdateModel extends RepresentationModel<BlobUpdateModel> {
    private final String id;
    private ExpirationType expirationType;
    private Integer expire;
}
