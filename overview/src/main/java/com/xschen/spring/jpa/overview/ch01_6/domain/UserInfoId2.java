package com.xschen.spring.jpa.overview.ch01_6.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * {@link UserInfo2} 的联合主键, 使用 {@link Embeddable}
 * @author xschen
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserInfoId2 implements Serializable {
    private String name;
    private String telephone;
}
