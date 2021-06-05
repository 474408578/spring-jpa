package com.xschen.spring.jpa.overview.ch07.one2many;

import com.xschen.spring.jpa.overview.ch07.one2many.domain.User;
import com.xschen.spring.jpa.overview.ch07.one2many.domain.UserAddress;
import com.xschen.spring.jpa.overview.ch07.one2many.repository.UserAddressRepository;
import com.xschen.spring.jpa.overview.ch07.one2many.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xschen
 */
@SpringBootApplication
public class OverViewApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(OverViewApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        init();
    }

    @Autowired
    private UserAddressRepository userAddressRepository;
    @Autowired
    private UserRepository userRepository;

    // 添加数据
    @Transactional
    void init() {
        User user = User.builder().name("jackxx").email("123456@126.com").build();
        UserAddress userAddress = UserAddress.builder().address("shanghai1").user(user).build();
        UserAddress userAddress2 = UserAddress.builder().address("shanghai2").user(user).build();
        userAddressRepository.saveAll(Lists.newArrayList(userAddress,userAddress2));
        User user1 = userRepository.getOne(1L);
        System.out.println(user1.getName());
        System.out.println(user1.getAddress());
    }

}
