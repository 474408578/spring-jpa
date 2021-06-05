package com.xschen.spring.jpa.overview.ch01_6.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * {@link UserInfo} 的联合主键
 * @author xschen
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoId implements Serializable {
    private String name;
    private String telephone;
}
