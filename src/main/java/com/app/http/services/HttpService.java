package com.app.http.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpService {

    private RestTemplate restTemplate;

    public HttpService() {
        this.restTemplate = new RestTemplate();
    }

    public <T> T get(String url, Class<T> responseType) {
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType);
        return responseEntity.getBody();
    }
    
    public <T, R> R post(String url, T request , Class<R> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> httpEntity = new HttpEntity<>(request, headers);
        ResponseEntity<R> responseEntity = restTemplate.postForEntity(url, httpEntity, responseType);
 
	    return responseEntity.getBody();
    }
    
    public <T, R> R put(String url, T request , Class<R> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<T> httpEntity = new HttpEntity<>(request, headers);
        ResponseEntity<R> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, responseType);

	    return responseEntity.getBody();
    }
    
    public <T> T delete(String url, Class<T> responseType) {
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, responseType);
	    return responseEntity.getBody();
    }
   
}
