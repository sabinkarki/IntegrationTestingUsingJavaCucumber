package runner;

import config.ApplicationProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import glue.hook.DropUsers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import rest.resource.UserApiResource;

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
        ApplicationProperties properties = new ApplicationProperties();
        UserApiResource userApiResource = new UserApiResource(properties);
        DropUsers dropUsers = new DropUsers(userApiResource);
        dropUsers.tearDownUsers();
    }

    @BeforeClass
    public static void setUp() {
        //Runs only once before test
    }
}
