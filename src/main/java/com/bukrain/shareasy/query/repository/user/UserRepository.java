package com.bukrain.shareasy.query.repository.user;

import com.bukrain.shareasy.query.entity.user.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, String> {
}
