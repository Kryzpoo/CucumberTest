package siriustest.run;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "siriustest.manage", "siriustest.steps" },
        features = "Features",
        format = { "pretty", "html:target/reports-pretty", "json:target/cucumber.json" },
        monochrome=true)
public class RunnerTest {}