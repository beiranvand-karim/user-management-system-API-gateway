package com.example.usermanagementsystemAPIgateway.controller;


import com.example.usermanagementsystemAPIgateway.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class APIController {

    @Autowired
    private RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<?> entity = new HttpEntity<>(headers);

    @GetMapping("/adduser")
    public ResponseEntity<UserModel> addUserModel() {


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/users")
                .queryParam("id", "1")
                .queryParam("name", "ali")
                .queryParam("emailAddress", "hello@gmail.com");


        ResponseEntity<UserModel> userModel = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.POST,
                entity,
                UserModel.class
                );
        return userModel;
    }

    @GetMapping("/getuser")
    public ResponseEntity<UserModel> getUser() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/user")
                .queryParam("id", "1");


        ResponseEntity<UserModel> userModel = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                UserModel.class
        );
        return userModel;
    }

    @GetMapping("/getusers")
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

    @GetMapping("/deleteuser")
    public ResponseEntity<String> deleteUser() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/users")
                .queryParam("id","1");

        ResponseEntity<String> userModel = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.DELETE,
                entity,
                String.class
        );
        return userModel;
    }

}
