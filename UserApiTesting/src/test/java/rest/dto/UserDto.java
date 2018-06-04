package rest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by sabin on 5/20/2018.
 */
@Data
@EqualsAndHashCode
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String state;

    public UserDto(){}
    public UserDto(String firstName, String lastName, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }
}
