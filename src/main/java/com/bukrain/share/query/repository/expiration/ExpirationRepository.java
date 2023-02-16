package com.bukrain.share.query.repository.expiration;

import com.bukrain.share.query.entity.expiration.Expiration;
import org.springframework.data.repository.ListCrudRepository;

public interface ExpirationRepository extends ListCrudRepository<Expiration, String> {
}
