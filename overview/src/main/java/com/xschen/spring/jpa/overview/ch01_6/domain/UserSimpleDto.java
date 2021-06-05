package com.xschen.spring.jpa.overview.ch01_6.domain;

/**
 * 利用 UserDto 接口获得我们想要的结果
 * @author xschen
 */

public interface UserSimpleDto {
    String getName();
    String getEmail();
    String getIdCard();
}
