package cput.ac.za.mobilebanking1.repositories.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Scorpian on 2016-08-31.
 */
public class RestMethods {

    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // Add the Gson message converter
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return restTemplate;
    }


    public static HttpHeaders getHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;
    }


}
