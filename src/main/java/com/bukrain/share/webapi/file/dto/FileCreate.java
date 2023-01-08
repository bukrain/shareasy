package com.bukrain.share.webapi.file.dto;

import com.bukrain.share.file.ExpirationType;

public record FileCreate(String name, ExpirationType expirationType, int size, Integer expire) {
}
