package com.xschen.spring.jpa.overview.ch01_6.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * 采用 {@link IdClass} 引用联合主键类
 * @author xschen
 */


@Entity
@IdClass(UserInfoId.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Integer age;
    @Id
    private String name;
    @Id
    private String telephone;
}
