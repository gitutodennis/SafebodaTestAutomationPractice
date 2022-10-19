package testrunners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/features"},
        glue = {"stepdefinition", "apphooks"},
        tags = "@ItemsOnCart",
        plugin = {"pretty"}
)
public class MyTestRunner {


}
