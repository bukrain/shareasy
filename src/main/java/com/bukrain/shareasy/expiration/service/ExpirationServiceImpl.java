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
        return expirationRepository.save(expiration);
    }
}
