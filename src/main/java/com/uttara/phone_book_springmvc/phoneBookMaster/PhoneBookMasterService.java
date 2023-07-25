package com.uttara.phone_book_springmvc.phoneBookMaster;

import java.io.Reader;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
public class PhoneBookMasterService {
     WebClient webClient = WebClient.create("http://localhost:9090");

     public List<PhoneBookMaster> getAll() {
        List<PhoneBookMaster> result = webClient.get()
                                        .uri("/api/phoneBookMasters")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .bodyToMono(new ParameterizedTypeReference<List<PhoneBookMaster>>() {})
                                        .block();  
        // result.forEach(one -> System.out.println(one.getName()));  
        return result;                                                                  
    }

    public Long create(PhoneBookMaster phoneBookMaster) {
        System.out.println();
        Long createdID = webClient.post()
                                  .uri("/api/phoneBookMasters")
                                  .accept(MediaType.APPLICATION_JSON)
                                  .bodyValue(phoneBookMaster)
                                  .retrieve()
                                  .bodyToMono(Long.class)
                                  .block();
        return createdID;                                  
    }


    
}
