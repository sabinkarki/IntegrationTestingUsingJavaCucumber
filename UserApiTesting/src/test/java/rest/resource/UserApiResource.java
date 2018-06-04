package rest.resource;

import config.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rest.dto.UserDto;
import rest.helper.RestHelper;

import java.util.List;

/**
 * Created by sabin on 5/20/2018.
 */
@Slf4j
public class UserApiResource {

    private String resourceUrl;

    public UserApiResource(ApplicationProperties applicationProperties) {
        this.resourceUrl = applicationProperties.getProperty("user.api.url");
    }

    public List<UserDto> getUsers(String path, String userId) {
        String resourceUrl = this.resourceUrl + path;
        try {
            RestTemplate restTemplate = RestHelper.getRestTemplate();
            HttpHeaders headers = RestHelper.getHeaders();
            HttpEntity entity = new HttpEntity(headers);

            if (userId != null) {
                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(resourceUrl)
                        .queryParam("userId", userId);
                resourceUrl = builder.toUriString();
            }
            HttpEntity<List<UserDto>> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<UserDto>>() {
            });
            List<UserDto> userDtos = usersTemp.getBody();
            return userDtos;
        } catch (Exception e) {
            log.error("Error occured in UserApiResource.getUsers", e.getMessage());
            throw new RuntimeException("Exception in UserApiResource.getUsers", e);
        }
    }

    public void postUsers(UserDto userDto) {
        String resourceUrl = this.resourceUrl + "/";
        try {
            RestTemplate restTemplate = RestHelper.getRestTemplate();
            HttpHeaders headers = RestHelper.getHeaders();
            HttpEntity<UserDto> entity = new HttpEntity(userDto, headers);
            HttpEntity<String> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.POST, entity, String.class);

        } catch (Exception e) {
            log.error("Error occured in UserApiResource.postUsers", e.getMessage());
            throw new RuntimeException("Exception in UserApiResource.postUsers", e);
        }
    }

    public void deleteAddedUser() {
        String resourceUrl = this.resourceUrl + "/";
        RestTemplate restTemplate = RestHelper.getRestTemplate();
        HttpHeaders headers = RestHelper.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        HttpEntity<String> usersTemp = restTemplate.exchange(resourceUrl, HttpMethod.DELETE, entity, String.class);
    }
}
