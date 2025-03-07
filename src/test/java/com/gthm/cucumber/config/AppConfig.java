package com.gthm.cucumber.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfig {

    @Value("${onestream.api}")
    String oneStreamAPIURL;

}