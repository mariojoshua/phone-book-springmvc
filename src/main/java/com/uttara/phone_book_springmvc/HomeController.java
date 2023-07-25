package com.uttara.phone_book_springmvc;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.uttara.phone_book_springmvc.phoneBookMaster.PhoneBookMaster;
import com.uttara.phone_book_springmvc.phoneBookMaster.PhoneBookMasterService;

import reactor.core.publisher.Mono;


@Controller
public class HomeController {
    
    @Autowired
    PhoneBookMaster phoneBookMaster;
   

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    

}
