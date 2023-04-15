package com.bukrain.shareasy.webapi.blob.dto;

import com.bukrain.shareasy.expiration.ExpirationType;

public record BlobUpdate(ExpirationType expirationType, int expire) {
}
