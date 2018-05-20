package rest.dto;

import lombok.Data;

/**
 * Created by sabin on 5/20/2018.
 */
@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String state;
}
