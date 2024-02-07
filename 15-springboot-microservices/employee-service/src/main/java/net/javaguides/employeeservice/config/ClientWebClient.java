package net.javaguides.employeeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClientWebClient {

    @Bean
    public WebClient webClient(){
        return  WebClient.builder().build();
    }
}
