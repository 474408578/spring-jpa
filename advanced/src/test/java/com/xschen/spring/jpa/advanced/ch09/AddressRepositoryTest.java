package com.xschen.spring.jpa.advanced.ch09;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xschen.spring.jpa.advanced.ch09.entity.Address;
import com.xschen.spring.jpa.advanced.ch09.entity.SexEnum;
import com.xschen.spring.jpa.advanced.ch09.entity.User;
import com.xschen.spring.jpa.advanced.ch09.repository.AddressRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author xschen
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;
    //@Autowired
    //private ObjectMapper mapper;

    @BeforeAll
    @Rollback(value = false)
    @Transactional
    public void init() {
        User user = User.builder()
                .name("song").age(24).email("123456@qq.cpm").sex(SexEnum.BOY)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        Address shanghai = Address.builder()
                .user(user).address("shanghai")
                .build();
        Address beijing = Address.builder()
                .user(user).address("beijing")
                .build();

        addressRepository.saveAll(Arrays.asList(shanghai, beijing));
    }

    @Test
    @Rollback(value = false)
    public void testQBEFromAddress() throws JsonProcessingException {
        User request = User.builder()
                .name("song").age(24).email("123")
                .build();
        Address address = Address.builder()
                .user(request).address("shang")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address));

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("user.email", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.startsWith());

        Page<Address> addresses = addressRepository.findAll(Example.of(address, matcher),
                PageRequest.of(0, 2));

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addresses));
    }
}