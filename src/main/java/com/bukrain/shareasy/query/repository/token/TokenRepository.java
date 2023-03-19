package com.bukrain.shareasy.query.repository.token;

import com.bukrain.shareasy.query.entity.token.Token;
import org.springframework.data.repository.ListCrudRepository;

public interface TokenRepository extends ListCrudRepository<Token, String> {
}
