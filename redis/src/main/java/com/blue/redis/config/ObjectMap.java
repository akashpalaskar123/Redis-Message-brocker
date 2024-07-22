package com.blue.redis.config;

import com.blue.redis.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ObjectMap {

    private final ObjectMapper objectMapper;


    public ObjectMap(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

//    public Product convert(String message) throws IOException {
//        return objectMapper.readValue(message, Product.class);
//    }
}
