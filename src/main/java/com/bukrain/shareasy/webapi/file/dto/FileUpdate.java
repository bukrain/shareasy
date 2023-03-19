package com.bukrain.shareasy.webapi.file.dto;

import com.bukrain.shareasy.file.ExpirationType;

public record FileUpdate(ExpirationType expirationType, int expire) {
}
