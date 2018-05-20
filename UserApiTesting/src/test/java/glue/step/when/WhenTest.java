package glue.step.when;

import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

/**
 * Created by sabin on 5/20/2018.
 */
public class WhenTest {

    @When("^Test When$")
    public void test_When() throws Throwable {
        assertTrue(true);
    }
}
