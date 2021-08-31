import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/TC01",
        glue = "com.testcases.TC01",
        monochrome = true)
public class WebTestingTC01 {
}

