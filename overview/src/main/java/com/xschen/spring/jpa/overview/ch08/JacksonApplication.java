package com.xschen.spring.jpa.overview.ch08;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xschen
 * @see JsonGenerator
 * @see JsonParser
 */

@SpringBootApplication
public class JacksonApplication {

    public static void main(String[] args) {
        SpringApplication.run(JacksonApplication.class, args);
    }
}
