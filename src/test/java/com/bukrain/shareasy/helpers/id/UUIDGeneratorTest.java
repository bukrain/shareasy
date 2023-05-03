package com.bukrain.shareasy.helpers.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UUIDGeneratorTest {

    @Test
    void whenGenerateId_returnNonNullString(){
        var idGenerator = new UUIDGenerator();
        assertNotNull(idGenerator.generateId());
    }
}
