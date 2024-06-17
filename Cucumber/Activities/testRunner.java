import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "Features",
        glue = {"stepDefinition"},
        tags = "@Activity5",
        strict = true,
        plugin = {"pretty"},
        monochrome = true
)
public class testRunner {
}
