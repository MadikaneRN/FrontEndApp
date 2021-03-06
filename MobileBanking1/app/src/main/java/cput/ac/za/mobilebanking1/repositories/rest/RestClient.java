package cput.ac.za.mobilebanking1.repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import cput.ac.za.mobilebanking1.domain.Client;
import cput.ac.za.mobilebanking1.repositories.RestAPI;

/**
 * Created by Scorpian on 2016-08-31.
 */
public class RestClient implements RestAPI<Client,Long>{


    final String BASE_URL = "https://updateback.herokuapp.com/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();


    public Client get(Long id) {

        final String url = BASE_URL+"client/" +id.toString();

        HttpEntity<Client> requestEntity = new HttpEntity<>(requestHeaders);
        //restTemplate.getMessageConverters();
        ResponseEntity<Client> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, requestEntity, Client.class);

        Client packages = responseEntity.getBody();

        return packages;
    }


    @Override
    public String post(Client entity) {

        final String url = BASE_URL+"client/create";
        HttpEntity<Client> requestEntity = new HttpEntity<>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }


    @Override
    public String put(Client entity) {

        String id = Long.toString(entity.getId());

        final String url = BASE_URL+"client/update/"+id; //entity.getId().toString();
        HttpEntity<Client> requestEntity = new HttpEntity<Client>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;

    }


    @Override
    public String delete(Client entity) {
        String id = Long.toString(entity.getId());


        final String url = BASE_URL+"client/delete/"+id; //entity.getId().toString();



        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);

        String result = responseEntity.getBody();
        return result;
    }


    @Override
    public List<Client> getAll() {

        List<Client> packages = new ArrayList<>();
        final String url = BASE_URL+"clients/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Client[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Client[].class);
        Client[] results = responseEntity.getBody();


        for (Client subject : results) {
            packages.add(subject);
        }
        return packages;

    }







}
