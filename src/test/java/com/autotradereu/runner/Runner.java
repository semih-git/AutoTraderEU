package com.autotradereu.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/autotradereu/stepdef",
        dryRun =false,
        strict = true,
        //  tags = "@smoke_test, @unit_test",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class Runner {

}
