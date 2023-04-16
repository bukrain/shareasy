package com.bukrain.shareasy.expiration.service;

import com.bukrain.shareasy.query.entity.expiration.Expiration;
import com.bukrain.shareasy.query.repository.expiration.ExpirationRepository;

public class ExpirationServiceImpl implements ExpirationService{

    private final ExpirationRepository expirationRepository;

    public ExpirationServiceImpl(ExpirationRepository expirationRepository) {
        this.expirationRepository = expirationRepository;
    }

    @Override
    public Expiration saveExpirationInformation() {
        Expiration expiration = new Expiration();
        expiration.setId();
        expiration.setExpirationType();
        expiration.setExpireDate();
        expiration.setExpired();
        expiration.setUseCount();
        return expirationRepository.save(expiration);
    }
}
