package com.xschen.spring.jpa.overview.ch01_6.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xschen
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private String name;
    private String email;
    private String idCard;
}
