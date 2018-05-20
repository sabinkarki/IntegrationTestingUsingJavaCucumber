package glue.step.then;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

/**
 * Created by sabin on 5/20/2018.
 */
public class ThenTest {

    @Then("^Test Then$")
    public void test_Then() throws Throwable {
        assertTrue(true);
    }

}
