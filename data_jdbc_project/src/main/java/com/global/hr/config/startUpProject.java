
package com.global.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class startUpProject implements CommandLineRunner {

	// دى عشان لو كود معين عاوزينه يشتغل اول مالبروجيكت يبدأ
    @Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
    public void run(String... args) throws Exception {
        // 
        System.out.println("Application has started successfully! (command line runner)");
        
    }
}
