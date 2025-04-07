package com.saucedemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.model.entities.TestData;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    private static final String PATH = "src/test/resources/data/test-data.json";

    public static TestData load() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(PATH), TestData.class);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo JSON: " + PATH, e);
        }
    }
}
