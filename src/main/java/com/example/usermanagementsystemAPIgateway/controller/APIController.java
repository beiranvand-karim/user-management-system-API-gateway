package com.example.usermanagementsystemAPIgateway.controller;


import com.example.usermanagementsystemAPIgateway.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class APIController {

    @Autowired
    private RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<?> entity = new HttpEntity<>(headers);

    @CrossOrigin
    @PostMapping("/api/users")
    public ResponseEntity<UserModel> addUser(@RequestParam String firstName, @RequestParam String lastName , @RequestParam String emailAddress) {

        System.out.println(firstName);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/users")
                .queryParam("firstName", firstName)
                .queryParam("lastName",lastName)
                .queryParam("emailAddress",emailAddress);

        ResponseEntity<UserModel> responseEntity = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.POST,
                entity,
                UserModel.class
                );
        return responseEntity;
    }

    @CrossOrigin
    @GetMapping("/api/user")
    public ResponseEntity<UserModel> getUser(@RequestParam String id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/user")
                .queryParam("id", id);


        ResponseEntity<UserModel> userModel = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                UserModel.class
        );
        return userModel;
    }

    @CrossOrigin
    @GetMapping("/api/users")
    public ResponseEntity<String> getUsers() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/users");

        ResponseEntity<String> userModel = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                String.class
        );
        return userModel;
    }

    @CrossOrigin
    @DeleteMapping("/api/users")
    public ResponseEntity<String> deleteUser(@RequestParam String id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/users")
                .queryParam("id",id);

        ResponseEntity<String> userModel = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.DELETE,
                entity,
                String.class
        );
        return userModel;
    }

}
