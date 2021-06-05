package com.xschen.spring.jpa.overview.ch08;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xschen.spring.jpa.overview.ch08.entity.User;
import com.xschen.spring.jpa.overview.ch08.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xschen
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserJsonTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    @Rollback(false)
    @Transactional
    void init() {
        User user = User.builder()
                .name("song")
                .createDate(Instant.now())
                .updateDate(new Date())
                .sex("man")
                .email("123@qq.com")
                .build();
        userRepository.saveAndFlush(user);
    }

    @Test
    public void testUserJson() throws JsonProcessingException {
        User user = userRepository.findById(1L).get();
        Map<String, Object> map = new HashMap<>();
        map.put("address", "ShangHai");
        user.setOther(map);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }

}
