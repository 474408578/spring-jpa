package com.xschen.spring.jpa.overview.ch07.one2many.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
     * targetEntity: 对方对象的字节码对象（使用泛型时，可空）
     */
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<UserAddress> address;
}
