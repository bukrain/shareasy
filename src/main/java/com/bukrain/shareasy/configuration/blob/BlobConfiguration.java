package com.bukrain.shareasy.configuration.blob;

import com.bukrain.shareasy.blob.facade.BlobFacade;
import com.bukrain.shareasy.blob.facade.BlobFacadeImpl;
import com.bukrain.shareasy.blob.service.BlobService;
import com.bukrain.shareasy.blob.service.BlobServiceImpl;
import com.bukrain.shareasy.expiration.service.ExpirationService;
import com.bukrain.shareasy.helpers.id.IdGenerator;
import com.bukrain.shareasy.query.repository.blob.BlobMetadataRepository;
import com.bukrain.shareasy.query.repository.blob.BlobRepository;
import com.bukrain.shareasy.webapi.blob.model.BlobToBlobModelConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unused")
public class BlobConfiguration {

    @Bean
    @SuppressWarnings("unused")
    public BlobFacade blobFacade(
            BlobToBlobModelConverter converter,
            BlobService service,
            ExpirationService expirationService
    ) {
        return new BlobFacadeImpl(converter, service, expirationService);
    }

    @Bean
    @SuppressWarnings("unused")
    public BlobService blobService(
            BlobRepository blobRepository,
            BlobMetadataRepository blobMetadataRepository,
            IdGenerator idGenerator
    ){
        return new BlobServiceImpl(blobRepository, blobMetadataRepository, idGenerator);
    }

    @Bean
    @SuppressWarnings("unused")
    public BlobToBlobModelConverter blobToBlobModelConverter(){
        return new BlobToBlobModelConverter();
    }
}
