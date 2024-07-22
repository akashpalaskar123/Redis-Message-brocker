package com.blue.redis.publisher;

import com.blue.redis.dto.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {


    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic topic;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/publish")
    public String publisher(@RequestBody Product product) throws JsonProcessingException {
        String productJson = objectMapper.writeValueAsString(product);

        System.out.println("This Produce data: " + productJson);
        try {
            template.convertAndSend(topic.getTopic(), productJson);
        } catch (Exception e) {
            System.out.println("fkjsndkjsdfsd");
            e.printStackTrace();
        }
        return "Event Publish";
    }


}
