package com.sparta.memberpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MemberPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberPostApplication.class, args);
    }

}
