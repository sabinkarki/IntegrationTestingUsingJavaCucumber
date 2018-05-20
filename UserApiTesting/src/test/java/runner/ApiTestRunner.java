package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by sabin on 5/20/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "html:target/cucumber/api",
                "json:target/reports/cucumber/api.json"
        },
        tags = {"~@ignored", "@api"},
        features = "classpath:feature",
        glue = {"classpath:glue"}
)
public class ApiTestRunner {

    @AfterClass
    public static void dropDown() {
        //Runs only once after all suite
    }

    @BeforeClass
    public static void setUp() {
        //Runs only once before test
    }
}
