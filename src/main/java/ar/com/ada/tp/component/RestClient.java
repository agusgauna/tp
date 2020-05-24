package ar.com.ada.tp.component;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient<T> {
    private RestTemplate restTemplate = new RestTemplate();

    public T getOne(String url, ParameterizedTypeReference<T> responseType) {
        ResponseEntity<T> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );
        return responseEntity.getBody();
    }
    public List<T> getList(String url, ParameterizedTypeReference<List<T>> responseType) {
        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );

        return responseEntity.getBody();
    }

    public ResponseEntity<T> post(String url, T body, ParameterizedTypeReference<T> responseType) {

        HttpEntity entity = new HttpEntity(body);

        ResponseEntity<T> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                responseType
        );

        return responseEntity;
    }
}
