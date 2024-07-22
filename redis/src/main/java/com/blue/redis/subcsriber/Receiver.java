package com.blue.redis.subcsriber;

import com.blue.redis.dto.Product;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver implements MessageListener {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    private static final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper


    @Override
    public void onMessage(Message message, byte[] pattern) {
            String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
            

        logger.info("Consumed event :" + message);
        try {
            Product product = objectMapper.readValue(messageBody, Product.class);
            // get sting and convert it tp product obj

//            Product product = (Product) message;
            System.out.println("message from message broker");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getQty());
            System.out.println(product.getPrice());

        } catch (JsonParseException e) {
            // Log the exception and handle it gracefully
            System.err.println("Error parsing JSON: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
