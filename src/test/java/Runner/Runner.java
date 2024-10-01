package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/test.feature",
        glue = {"Steps"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class Runner {
}