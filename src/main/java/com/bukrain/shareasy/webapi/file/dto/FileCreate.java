package com.bukrain.shareasy.webapi.file.dto;

import com.bukrain.shareasy.file.ExpirationType;

public record FileCreate(String name, ExpirationType expirationType, int size, Integer expire) {
}
