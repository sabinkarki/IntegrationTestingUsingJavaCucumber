package glue.step.given;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import rest.dto.UserDto;
import rest.resource.UserApiResource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sabin on 5/20/2018.
 */
@RequiredArgsConstructor
public class Users {

    @NonNull
    private UserApiResource userApiResource;

    @Given("^Two users should exist in the system$")
    public void two_users_should_exist_in_the_system() throws Throwable {
        // User Sabin Branch and User Nikita Master already exist in http://localhost:8080 so intentionally left balnk
    }

    @Given("^User details given$")
    public void user_details_given(DataTable usersFromFeatureFile) throws Throwable {
        List<Map<String, String>> users = usersFromFeatureFile.asMaps(String.class, String.class);
        UserDto[] userDtos = getUsersDto(users);
        for (UserDto userDtoTemp : userDtos) {
            this.userApiResource.postUsers(userDtoTemp);
        }

    }

    public UserDto[] getUsersDto(List<Map<String, String>> users) {
        UserDto[] userDtos = users.stream()
                .map(usersInMap -> {
                    String firstName = usersInMap.get("FirstName");
                    String lastName = usersInMap.get("LastName");
                    String state = usersInMap.get("State");
                    return new UserDto(firstName, lastName, state);
                }).toArray(UserDto[]::new);
        return userDtos;
    }
}
