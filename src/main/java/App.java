import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/resources/weather.feature", "src/main/resources/HelloWorld.feature"}, glue = "stepDefinition", tags = "@city or @hello")
public class App {


}
