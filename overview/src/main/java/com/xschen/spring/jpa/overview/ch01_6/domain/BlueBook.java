package com.xschen.spring.jpa.overview.ch01_6.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entity 对象 BlueBook 指向 Book 这张表
 * @author xschen
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("blue") // Book 中的 color 字段
public class BlueBook extends Book {
    private String blueMark;
}
