package com.xschen.spring.jpa.overview.ch01_6.controller;

import com.xschen.spring.jpa.overview.ch01_6.domain.*;
import com.xschen.spring.jpa.overview.ch01_6.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * @author xschen
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PagingAndSortingUserRepository pagingAndSortingUserRepository;
    @Autowired
    private UserDtoRepository userDtoRepository;
    @Autowired
    private UserExtendRepository userExtendRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserInfo2Repository userInfo2Repository;

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping(path = "user",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * 获取所有用户
     * @param req
     * @return
     */
    @GetMapping(path = "users")
    public List<User> getAllUsers(Pageable req) {
        return userRepository.findAll();
    }

    @GetMapping(path = "user1")
    public List<User> getUserByName(@RequestParam("name") String name) {
        return userRepository.findByName(name);
    }

    @GetMapping(path = "singleUser1")
    public List<User> getUserByNameAndEmail1(@RequestParam("name") String name, @RequestParam("email") String email) {
        return userRepository.findByNameAndEmail(name, email);
    }

    @GetMapping(path = "singleUser2")
    public User getUserByNameAndEmail2(@RequestParam("name") String name, @RequestParam("email") String email) {
        return userRepository.findByNameAndEmail2(name, email);
    }

    /**
     * 根据排序和分页查询，Pageable的默认实现类：PageRequest
     */
    @GetMapping(path = "page")
    public Page<User> getAllUserByPage() {
        return pagingAndSortingUserRepository
                .findAll(PageRequest.of(0,20,
                        Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))));
    }

    /**
     * 排序查询方法，使用sort对象
     * @return
     */
    public Iterable<User> getAllUserWithSort() {
        return pagingAndSortingUserRepository
                .findAll(Sort.by(new Sort.Order(Sort.Direction.ASC, "name")));
    }

    @GetMapping("userDto1")
    public UserDto getUserById1(@RequestParam("id") Long id) {
        List<Object[]> objects = userDtoRepository.findByUserDtoId1(id);
        UserDto userDto = new UserDto();
        userDto.setName((String) objects.get(0)[0]);
        userDto.setEmail((String) objects.get(0)[1]);
        userDto.setIdCard((String) objects.get(0)[2]);
        return userDto;
    }

    @GetMapping("userDto2")
    public UserDto getUserById2(@RequestParam("id") Long id) {
        UserDto userDto = userDtoRepository.findByUserDtoId2(id);
        return userDto;
    }

    @GetMapping("userDto3")
    public UserSimpleDto getUserById3(@RequestParam("id") Long id) {
        UserSimpleDto userSimpleDto = userDtoRepository.findByUserDtoId3(id);
        return userSimpleDto;
    }

    @PostMapping("userInfo")
    public UserInfo getUserInfoByUserInfoId(@RequestBody UserInfoId userInfoId) {
        Optional<UserInfo> userInfo = userInfoRepository.findById(userInfoId);
        return userInfo.get();
    }

    @PostMapping("userInfo2")
    public UserInfo2 getUserInfo2ByUserInfoId2(@RequestBody UserInfoId2 userInfoId2) {
        Optional<UserInfo2> userInfo2 = userInfo2Repository.findById(userInfoId2);
        return userInfo2.get();
    }

    @PostConstruct
    private void initData() {
        User xschen = User.builder().name("xschen").email("1638392300@qq.com").build();
        userRepository.save(xschen);
        User xiangsong = User.builder().name("xiangsong").email("474408578@qq.com").build();
        userRepository.save(xiangsong);
        UserExtend userExtend = UserExtend.builder().userId(1L).age(23).idCard("123456").build();
        userExtendRepository.save(userExtend);

        UserInfo userinfo = UserInfo.builder().age(23).name("song").telephone("123456").build();
        userInfoRepository.save(userinfo);

        UserInfoId2 userInfoId2 = UserInfoId2.builder().name("songsong").telephone("123456").build();
        UserInfo2 userInfo2 = UserInfo2.builder().age(23).userInfoId2(userInfoId2).build();
        userInfo2Repository.save(userInfo2);
    }
}
