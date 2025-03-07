package com.gthm.cucumber.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gthm.cucumber.config.AppConfig;
import jakarta.annotation.PostConstruct;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.gthm.cucumber.model.Account;
import java.io.IOException;
import java.nio.charset.Charset;

public class FeatureUtils {

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

    public static JSONObject getMockOneStreamEvent() throws JSONException, IOException {

        Resource resource = new ClassPathResource("packet.json");
        try {

            String content = resource.getContentAsString(Charset.defaultCharset());
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject;
        } catch (Exception e) {
            throw e;
        }
    }

}
