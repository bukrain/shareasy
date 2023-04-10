package com.bukrain.shareasy.configuration.blob;

import com.bukrain.shareasy.blob.facade.BlobFacade;
import com.bukrain.shareasy.blob.facade.BlobFacadeImpl;
import com.bukrain.shareasy.blob.service.BlobService;
import com.bukrain.shareasy.blob.service.BlobServiceImpl;
import com.bukrain.shareasy.query.repository.blob.BlobRepository;
import com.bukrain.shareasy.webapi.blob.model.BlobToBlobModelConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlobConfiguration {

    @Bean
    public BlobFacade blobFacade(BlobToBlobModelConverter converter, BlobService service) {
        return new BlobFacadeImpl(converter, service);
    }

    @Bean
    public BlobService blobService(BlobRepository blobRepository){
        return new BlobServiceImpl(blobRepository);
    }

    @Bean
    public BlobToBlobModelConverter blobToBlobModelConverter(){
        return new BlobToBlobModelConverter();
    }
}
