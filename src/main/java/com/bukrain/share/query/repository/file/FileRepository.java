package com.bukrain.share.query.repository.file;

import com.bukrain.share.query.entity.file.File;
import org.springframework.data.repository.ListCrudRepository;

public interface FileRepository extends ListCrudRepository<File, String> {
}
