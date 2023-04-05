package com.coronavirustracker.coronavirustracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@SpringBootApplication
@EnableScheduling
public class CoronavirustrackerApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(CoronavirustrackerApplication.class, args);
	//	AuthClient authClient=context.getBean(AuthClient.class);
	//	authClient.getSignup();
	}

	//@Bean
	//public AuthClient getAuthClient()
	//{
	//	return new AuthClient();
	//}
    @Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
