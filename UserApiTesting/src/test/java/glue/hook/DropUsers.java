package glue.hook;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rest.resource.UserApiResource;
import cucumber.api.java.Before;

/**
 * Created by sabin on 5/20/2018.
 */
@Slf4j
@RequiredArgsConstructor
public class DropUsers {

    @NonNull
    private UserApiResource userApiResource;

    @Before("@dropUsers")
    public void tearDownUsers() {
        this.userApiResource.deleteAddedUser();
        log.info("Users deleted from DropUsers.tearDownUsers()");
    }
}
