package com.example.usermanagementsystemAPIgateway.controller;


import com.example.usermanagementsystemAPIgateway.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@RestController
public class APIController {

    @Autowired
    private RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<?> entity = new HttpEntity<>(headers);

    @CrossOrigin
    @PostMapping(value = "/api/users")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {

        System.out.println(user.getFirstName());

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user,headers);

        ResponseEntity<UserModel> responseEntity = restTemplate.exchange(
                "http://localhost:8081/users", HttpMethod.POST, entity, UserModel.class);

        return responseEntity;
    }

    @CrossOrigin
    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable String id) {

        System.out.println(id);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/user/" + id);

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
