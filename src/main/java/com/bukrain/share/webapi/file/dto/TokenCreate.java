package com.bukrain.share.webapi.file.dto;

import com.bukrain.share.file.ExpirationType;

public record TokenCreate(Integer expire, ExpirationType expirationType) {
}
