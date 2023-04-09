package com.bukrain.shareasy.webapi.file.dto;

import com.bukrain.shareasy.blob.ExpirationType;

public record FileUpdate(ExpirationType expirationType, int expire) {
}
