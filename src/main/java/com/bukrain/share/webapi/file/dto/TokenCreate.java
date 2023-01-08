package com.bukrain.share.webapi.file.dto;

import com.bukrain.share.token.TokenType;

public record TokenCreate(Integer expire, TokenType tokenType) {
}
