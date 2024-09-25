package tech.fivedhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tech.fivedhub.dto.UserRequestDto;

import java.net.URI;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class UserClient {
    private final RestTemplate template;
    private final String serverUrl;

    @Autowired
    public UserClient(@Value("${user-service.url}") String serverUrl, RestTemplateBuilder builder) {
        this.serverUrl = serverUrl;
        template = builder
                .requestFactory((Supplier<ClientHttpRequestFactory>) new HttpComponentsClientHttpRequestFactory())
                .build();
    }

    public UserRequestDto getUser(String lastName) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("id", String.valueOf(getUser(lastName).getUserId()));
        parameters.add("firstName", String.valueOf(getUser(lastName).getFirstName()));
        parameters.add("lastName", lastName);
        parameters.add("phone", String.valueOf(getUser(lastName).getPhone()));
        var typeReference = new ParameterizedTypeReference<UserRequestDto>() {
        };
        return makeAndSendRequest(HttpMethod.GET, "/users", parameters, null, typeReference).getBody();
    }

    private <T, R> ResponseEntity<R> makeAndSendRequest(HttpMethod method,
                                                        String path,
                                                        @Nullable MultiValueMap<String, String> parameters,
                                                        @Nullable T body,
                                                        ParameterizedTypeReference<R> typeReference) {
        HttpEntity<T> requestEntity = new HttpEntity<>(body, null);
        URI uri = UriComponentsBuilder.fromHttpUrl(serverUrl)
                .path(path)
                .queryParams(parameters)
                .build(Map.of());
        return template.exchange(uri, method, requestEntity, typeReference);
    }
}
