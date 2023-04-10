package com.bukrain.shareasy.webapi.blob.dto;

import com.bukrain.shareasy.blob.ExpirationType;

public record TokenCreate(Integer expire, ExpirationType expirationType) {
}
