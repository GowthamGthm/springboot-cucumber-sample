package com.gthm.cucumber.steps;

import com.gthm.cucumber.config.AppConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import com.gthm.cucumber.utils.FeatureUtils;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class OneStreamStep {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    AppConfig appConfig;

    private ResponseEntity<String> response;

    private JSONObject jsonObject;


    @Given("I request the onestream request object for {string}")
    public void i_request_the_onestream_request_object_for_application_id(String applicationID) throws JSONException, IOException {
        log.info("====== applicationID: {}", applicationID);
        JSONObject mockOneStreamEvent = FeatureUtils.getMockOneStreamEvent();
        mockOneStreamEvent.put("uuid", UUID.randomUUID().toString());

        JSONObject data = mockOneStreamEvent.getJSONObject("data");
        data.put("applicationId", applicationID);
        mockOneStreamEvent.put("data", data);
        jsonObject = mockOneStreamEvent;
    }


    @Then("I call the onestream API with the requestObject")
    public void thenAPICAll() {
        String request = jsonObject.toString();
        log.info("=============== JSON object: {}", request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestBody = new HttpEntity<>(request, headers);

        response = restTemplate.postForEntity(appConfig.getOneStreamAPIURL(), requestBody, String.class);
    }

    @And("the response of onestream should be {int}")
    public void theStatusCodeIs(int responseCode) {
        log.info("=============== response object: {}", responseCode);
        assertEquals(HttpStatusCode.valueOf(responseCode), response.getStatusCode());

        String body = response.getBody();
        log.info("============= response body {}", body);
        assertTrue(body.contains("SUCCESSFUL"));

    }

}