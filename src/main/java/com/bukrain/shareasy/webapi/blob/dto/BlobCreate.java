package com.bukrain.shareasy.webapi.blob.dto;

import com.bukrain.shareasy.expiration.ExpirationType;

public record BlobCreate(String name, ExpirationType expirationType, int size, Integer expire) {
}
