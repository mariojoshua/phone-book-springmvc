package com.uttara.phone_book_springmvc.phoneBookMaster;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import groovy.transform.ToString;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Component
@ToString
public class PhoneBookMaster {
    
    private Long id;

    @NotNull @Size(max = 255)
    private String name;
}
