package com.example.consumerApi2.service;
import com.example.consumerApi2.entity.Fare;
import com.example.consumerApi2.entity.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ConsumerService {

    @Value("${spring.security.oauth2.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client-secret}")
    private String clientSecret;

    private RestTemplate restTemplate;
    private int size;

    public ConsumerService() {
    }

    @Autowired
    public ConsumerService(RestTemplateBuilder restTemplatebuilder) {
        this.restTemplate = restTemplatebuilder.build();
    }

        public String getFare(String origin, String destination) throws JsonProcessingException {
    	long startTime = System.currentTimeMillis();
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(clientId, clientSecret);
        Fare fareDTO = new Fare();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(fareDTO);
        //String url = "http://localhost:8080/fares/AAL/ABE?currency=EUR";
        String url = "http://localhost:8080/fares/ABJ/ABQ?currency=EUR";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(fareDTO, headers), String.class);
        long endTime = System.currentTimeMillis();
        long totaltime = endTime - startTime;
        System.out.println("Total max time taken to get the Fare " +totaltime +"ms");
        response.getStatusCode().toString();
        return response.getBody();
    }

    public String getAirport() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(clientId, clientSecret);
        Location locDTO = new Location();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(locDTO);
        String url = "http://localhost:8080/airports/";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(locDTO, headers), String.class);
        return response.getBody();
    }
    /*public String getOriginDestination(String term) throws JsonProcessingException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBasicAuth("user", "secret123");
    Location locDTO = new Location();
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValueAsString(locDTO);

    List<Location> list = new ArrayList<Location>();
    Predicate<Location> filter = l -> l.getCode().toLowerCase().equals(term.toLowerCase())
                || l.getName().toLowerCase().equals(term.toLowerCase())
                || l.getDescription().toLowerCase().equals(term.toLowerCase());
    list =  list.stream().filter(filter).collect(Collectors.toList());
    System.out.println("**********************");
    for(Location i : list){
        System.out.println("list size :"+ list.size());
        System.out.println("list are :"+ i.getCode());
        System.out.println("list are :"+ i.getName());
    }
    //list.forEach(System.out::println);
    //Location l = list.size()>0 ? list.get(0)
    String result = (list.size()>0) ? list.get(0).getCode() : "";
    System.out.println("final result is "+ result);
    String url = "http://localhost:8080/airports/"+result;
    System.out.println("final URL is "+ url);
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(locDTO, headers), String.class);
    return response.getBody();
}*/

}
