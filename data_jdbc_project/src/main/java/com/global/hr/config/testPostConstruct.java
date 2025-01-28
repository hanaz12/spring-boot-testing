package com.global.hr.config;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class testPostConstruct {
	@PostConstruct
    public void init() {
        System.out.println("@PostConstruct: Bean is initialized!");
        
    
    }

}
