package com.bukrain.shareasy.storage.local;

import com.bukrain.shareasy.storage.ObjectStore;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.blobstore.domain.Blob;

import java.io.IOException;
import java.io.InputStream;

public class LocalObjectStore implements ObjectStore {

    private final BlobStore blobStore;

    public LocalObjectStore() {
        BlobStoreContext context = ContextBuilder.newBuilder("filesystem")
                .buildView(BlobStoreContext.class);
        blobStore = context.getBlobStore();
    }

    @Override
    public boolean containerExists(String containerName) {
        return blobStore.containerExists(containerName);
    }

    @Override
    public void createContainer(String containerName) {
        blobStore.createContainerInLocation(null, containerName);
    }

    @Override
    public void save(String containerName, String name, byte[] data) {
        Blob blob = blobStore.blobBuilder(name)
                .payload(data)
                .build();
        blobStore.putBlob(containerName, blob);
    }

    @Override
    public byte[] load(String containerName, String name) throws IOException {
        Blob blob = blobStore.getBlob(containerName, name);
        int size = blob.getMetadata().getSize().intValue();
        byte[] data = new byte[size];
        try(InputStream stream = blob.getPayload().openStream()) {
            stream.read(data);
        }

        return data;
    }
}
