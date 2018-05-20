package glue.step.when;

import cucumber.api.java.en.When;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import rest.dto.UserDto;
import rest.resource.UserApiResource;

import java.util.List;

/**
 * Created by sabin on 5/20/2018.
 */

@RequiredArgsConstructor
public class UsersServiceCall {

    @NonNull
    private UserApiResource resource;

    @Getter
    private List<UserDto> users;

    @When("^getAllUsers service is invoked$")
    public void users_service_is_invoked() throws Throwable {
        this.users = this.resource.getUsers("/users", null);
    }
}
