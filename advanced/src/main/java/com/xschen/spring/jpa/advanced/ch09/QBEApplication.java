package com.xschen.spring.jpa.advanced.ch09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @author xschen
 * @see QueryByExampleExecutor
 */

@SpringBootApplication
public class QBEApplication {

    public static void main(String[] args) {
        SpringApplication.run(QBEApplication.class, args);
    }
}
