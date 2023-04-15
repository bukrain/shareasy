package com.bukrain.shareasy.webapi.blob.dto;

import com.bukrain.shareasy.expiration.ExpirationType;

public record TokenCreate(Integer expire, ExpirationType expirationType) {
}
