package glue.step.given;

import cucumber.api.java.en.Given;

import static org.junit.Assert.assertTrue;

/**
 * Created by sabin on 5/20/2018.
 */
public class GivenTest {

    @Given("^Test Given$")
    public void test_Given() throws Throwable {
       assertTrue(true);
    }


}
