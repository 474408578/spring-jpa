package com.xschen.spring.jpa.advanced.ch09.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xschen
 */

@Configuration
public class JacksonConfig implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper mapper;

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module()
                .configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
    }

}
