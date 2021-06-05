package com.xschen.spring.jpa.overview.ch01_6.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * 采用 {@link EmbeddedId} 引用联合主键类
 * @author xschen
 */


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo2 {

    private Integer age;

    @EmbeddedId
    private UserInfoId2 userInfoId2;
}
