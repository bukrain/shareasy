package com.bukrain.shareasy.configuration.storage;

import com.bukrain.shareasy.storage.ObjectStore;
import com.bukrain.shareasy.storage.local.LocalObjectStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "storage", name = "local.enabled")
    public ObjectStore localObjectStore(){
        return new LocalObjectStore();
    }
}
