package com.bukrain.shareasy.query.repository.expiration;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import org.springframework.data.repository.ListCrudRepository;

public interface ExpirationRepository extends ListCrudRepository<Expiration, String> {
}
