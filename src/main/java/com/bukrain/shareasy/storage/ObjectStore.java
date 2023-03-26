package com.bukrain.shareasy.storage;

import java.io.IOException;

public interface ObjectStore {

    boolean containerExists(String containerName);
    void createContainer(String containerName);
    void save(String containerName, String name, byte[] data);
    byte[] load(String containerName, String name) throws IOException;
}
