package com.gthm.cucumber.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.gthm.cucumber.TutoCucumberSampleApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = TutoCucumberSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfiguration {

}
