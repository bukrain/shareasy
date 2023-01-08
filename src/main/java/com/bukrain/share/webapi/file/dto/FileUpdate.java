package com.bukrain.share.webapi.file.dto;

import com.bukrain.share.file.ExpirationType;

public record FileUpdate(ExpirationType expirationType, int expire) {
}
