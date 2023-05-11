package utils;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        plugin = {"pretty",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/cucumber.json",
        },
        glue = {"steps"},
        features = "src/test/resources/features",
        tags = "@1"//Теги по которым будут запускаться сценарии
)
public class TestRunner extends AbstractTestNGCucumberTests {
}