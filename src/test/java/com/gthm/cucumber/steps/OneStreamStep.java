package com.gthm.cucumber.steps;

import com.gthm.cucumber.config.AppConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import com.gthm.cucumber.utils.FeatureUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class OneStreamStep {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    AppConfig appConfig;

    private ResponseEntity<String> response;

    @When("I request the onestream endpoint {string}")
    public void iRequestTheEndpoint(String path) {
        log.info("-------------------------------------------- " + appConfig.getOneStreamAPIURL());
        response  = this.restTemplate.getForEntity(FeatureUtils.URL + path, String.class);
    }

    @Then("the response of onestream should be {string}")
    public void theResponseShouldBe(String version) {
        assertEquals(version, response.getBody());
    }

    @And("the status code of onestream is {int}")
    public void theStatusCodeIs(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }
}
