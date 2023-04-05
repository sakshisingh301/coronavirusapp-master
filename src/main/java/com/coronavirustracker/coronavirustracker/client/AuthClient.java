package com.coronavirustracker.coronavirustracker.client;


import com.coronavirustracker.coronavirustracker.dto.AuthenticationResponse;
import com.coronavirustracker.coronavirustracker.dto.LoginRequestDto;
import com.coronavirustracker.coronavirustracker.dto.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class AuthClient {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/signupclient")
    public ResponseEntity<String> getSignup(@RequestBody RegisterUserRequestDto registerUserRequestDto) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI("http://localhost:8082/api/auth/signup");
        HttpEntity<RegisterUserRequestDto> httpEntity = new HttpEntity<RegisterUserRequestDto>(registerUserRequestDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        return responseEntity;

    }

    @PostMapping("/signinclient")
    public String getSignin(@RequestBody LoginRequestDto loginRequestDto) throws URISyntaxException {
        AuthenticationResponse authenticationResponse=new AuthenticationResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        URI uri = new URI("http://localhost:8082/api/auth/signin");
        HttpEntity<LoginRequestDto> httpEntity = new HttpEntity<LoginRequestDto>(loginRequestDto, headers);
        ResponseEntity<AuthenticationResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, AuthenticationResponse.class);
        authenticationResponse=responseEntity.getBody();
        System.out.println(authenticationResponse.toString());
        return authenticationResponse.getJwtToken();

    }
}
