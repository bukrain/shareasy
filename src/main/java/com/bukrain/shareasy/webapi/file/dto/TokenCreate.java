package com.bukrain.shareasy.webapi.file.dto;

import com.bukrain.shareasy.file.ExpirationType;

public record TokenCreate(Integer expire, ExpirationType expirationType) {
}
