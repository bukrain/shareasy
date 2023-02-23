package com.bukrain.share.query.repository.user;

import com.bukrain.share.query.entity.user.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, String> {
}
