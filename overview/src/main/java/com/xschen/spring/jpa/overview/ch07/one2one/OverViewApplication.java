package com.xschen.spring.jpa.overview.ch07.one2one;

import com.xschen.spring.jpa.overview.ch07.one2one.domain.User;
import com.xschen.spring.jpa.overview.ch07.one2one.domain.UserInfo;
import com.xschen.spring.jpa.overview.ch07.one2one.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xschen
 * 表关系：
 *      一对一:
 *      一对多：
 *          一：主表
 *          多：从表
 *          外键：在从表上新建一列作为外键，它的取值来源于主表的主键
 *      多对多：
 *          中间表：最少应该由两个字段组成，这两个字段作为外键指向两张表的主键，又组成了联合主键。
 *
 * 实体类中的关系：
 *      包含关系
 *      继承关系
 *
 *
 *
 * 1. 明确表关系
 *      一对一
 * 2. 确定表关系（描述：外键|中间表）
 *      主表：user
 *      从表：userInfo
 *      外键：在userInfo中新建一列，作为外键，取值来源于主表的主键
 * 3. 编写实体类
 *      User类
 *      UserInfo类
 * 4. 配置映射关系
 * one to one 关联关系
 */
@SpringBootApplication
public class OverViewApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(OverViewApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        testUserInfoCasCade();
    }

    @Autowired
    UserInfoRepository userInfoRepository;

    /**
     * 测试级联新建和级联删除操作
     */
    public void testUserInfoCasCade() {
        User user = User.builder().name("song").email("123@qq.com").build();
        UserInfo userInfo = UserInfo.builder()
                .user(user) // 关联user
                .address("BeiJing")
                .build();

        // 保存 UserInfo 的同时，保存 User 信息
        userInfoRepository.saveAndFlush(userInfo);
        // 删除 UserInfo 的同时，删除 User 信息
        userInfoRepository.delete(userInfo);
    }
}
