package com.blaze.test.runner;

//import io.cucumber.junit.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin={("pretty"),
        "html:target/cucumber",
        "json:target/cucumber.json",
        },
        features = "src/test/resources/features",
        glue="com.blaze.test.steps",
       tags="@COM-1234"
)
public class COM_Blaze_Test {
}
