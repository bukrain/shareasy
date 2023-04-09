package com.bukrain.shareasy.webapi.file.model;

import com.bukrain.shareasy.blob.ExpirationType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@RequiredArgsConstructor
@Relation(collectionRelation = "tokens")
public class TokenModel extends RepresentationModel<TokenModel> {
    private final String id;
    private final Integer expire;
    private final boolean expired;
    private final ExpirationType expirationType;
}
