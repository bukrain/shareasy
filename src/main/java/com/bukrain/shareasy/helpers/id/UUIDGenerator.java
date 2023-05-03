package com.bukrain.shareasy.helpers.id;

import com.fasterxml.uuid.Generators;

public class UUIDGenerator implements IdGenerator{

    @Override
    public String generateId() {
        return Generators.timeBasedEpochGenerator().generate().toString();
    }
}
