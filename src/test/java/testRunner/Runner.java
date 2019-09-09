package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources"
        ,plugin = "pretty"
        ,glue = "stepdefs"
        ,tags = "@now")
//        ,tags = {"~@donttest"})
public class Runner
{
}