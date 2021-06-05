package com.xschen.spring.jpa.overview.ch07.one2one.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * UserInfo，{@link User} 的扩展信息
 * @author xschen
 * 外键的维护方
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    /**
     * 维护 User 的外键关联关系，配置为一对一
     *
     * alter table user_info
     *        add constraint FKn8pl63y4abe7n0ls6topbqjh2
     *        foreign key (user_id)
     *        references user
     */
    @OneToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private User user;
}
