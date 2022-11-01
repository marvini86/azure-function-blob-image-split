package br.com.wzapps.fnimagesplit.config;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlobStorageConfiguration {
    @Bean
    public BlobServiceClient blobServiceClient(){
        return new BlobServiceClientBuilder().connectionString(System.getenv("StorageConnectString")).buildClient();
    }

}
