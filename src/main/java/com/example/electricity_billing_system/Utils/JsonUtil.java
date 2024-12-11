package com.example.electricity_billing_system.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Method for reading JSON with a TypeReference
    public static <T> T readFromJsonFile(String filePath, TypeReference<T> typeReference) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            return objectMapper.readValue(file, typeReference);
        } else {
            throw new IOException("File not found: " + filePath);
        }
    }

    // Original method for reading JSON into a specific class
    public static <T> T readFromJsonFile(String filePath, Class<T> clazz) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            return objectMapper.readValue(file, clazz);
        } else {
            throw new IOException("File not found: " + filePath);
        }
    }

    // Method for writing JSON to a file
    public static <T> void writeToJsonFile(T data, String filePath) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }
}
