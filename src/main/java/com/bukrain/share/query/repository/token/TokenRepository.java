package com.bukrain.share.query.repository.token;

import com.bukrain.share.query.entity.token.Token;
import org.springframework.data.repository.ListCrudRepository;

public interface TokenRepository extends ListCrudRepository<Token, String> {
}
