package com.xschen.spring.jpa.overview.ch07.one2one.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author xschen
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String sex;

    /**
     * 配置双向关联关系，维护关联关系是拥有外键的一方（UserInfo）,
     * 只需在本实体类配置 mappedBy即可。
     */
    @OneToOne(mappedBy = "user") // mappedBy 的值是 UserInfo 内的加了 JoinTable/JoinColumn 的属性字段
    private UserInfo userInfo;
}
