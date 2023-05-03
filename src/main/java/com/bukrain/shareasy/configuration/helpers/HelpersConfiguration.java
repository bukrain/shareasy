package com.bukrain.shareasy.configuration.helpers;

import com.bukrain.shareasy.helpers.id.IdGenerator;
import com.bukrain.shareasy.helpers.id.UUIDGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unused")
public class HelpersConfiguration {

    @Bean
    @SuppressWarnings("unused")
    public IdGenerator uuidGenerator(){
        return new UUIDGenerator();
    }
}
