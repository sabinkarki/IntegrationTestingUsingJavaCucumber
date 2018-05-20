package glue.step.then;

import cucumber.api.java.en.Then;
import glue.step.when.UsersServiceCall;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by sabin on 5/20/2018.
 */

@RequiredArgsConstructor
public class UsersServiceValidation {

    @NonNull
    private UsersServiceCall usersServiceCall;

    @Then("^\"([^\"]*)\" users should exist$")
    public void users_should_exist(String expectedNumberOfUsers) throws Throwable {
        assertNotNull(this.usersServiceCall);
        assertNotNull(this.usersServiceCall.getUsers());
        assertEquals(expectedNumberOfUsers, String.valueOf(this.usersServiceCall.getUsers().size()));
    }
}
