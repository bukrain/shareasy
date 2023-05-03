package com.bukrain.shareasy.configuration.expiration;

import com.bukrain.shareasy.expiration.service.ExpirationService;
import com.bukrain.shareasy.expiration.service.ExpirationServiceImpl;
import com.bukrain.shareasy.query.repository.expiration.ExpirationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpirationConfiguration {

    @Bean
    public ExpirationService expirationService(ExpirationRepository expirationRepository) {
        return new ExpirationServiceImpl(expirationRepository);
    }
}
