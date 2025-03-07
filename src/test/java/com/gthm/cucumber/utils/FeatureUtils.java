package com.gthm.cucumber.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gthm.cucumber.config.AppConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.gthm.cucumber.model.Account;
import java.io.IOException;

public class FeatureUtils {

    @Autowired
    AppConfig appConfig;

    @PostConstruct
    public void test() {
        System.out.println("---------------------" + this.appConfig.getOneStreamAPIURL());
    }

    public static String URL = "http://localhost:9001";

    public static Account getMockAccount() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("Account.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Account.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
