package com.saucedemo.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestDataLoader {

    private static final String BASE_PATH = "src/test/resources/data/";

    public static <T> Map<String, T> loadTestCases(String fileName, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(BASE_PATH + fileName);
        return mapper.readValue(
                file,
                mapper.getTypeFactory().constructMapType(Map.class, String.class, valueType)
        );
    }
}
