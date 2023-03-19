package com.bukrain.shareasy.query.repository.file;

import com.bukrain.shareasy.query.entity.file.File;
import org.springframework.data.repository.ListCrudRepository;

public interface FileRepository extends ListCrudRepository<File, String> {
}
