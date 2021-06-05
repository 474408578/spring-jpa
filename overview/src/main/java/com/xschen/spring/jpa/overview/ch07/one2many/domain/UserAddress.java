package com.xschen.spring.jpa.overview.ch07.one2many.domain;

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
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    /**
     * 配置多对一关系
     */
    @ManyToOne(cascade = CascadeType.ALL) // 一定是维护主键关系的一方
    private User user;
}
