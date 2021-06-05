package com.xschen.spring.jpa.overview.ch01_6.repository;

import com.xschen.spring.jpa.overview.ch01_6.domain.RedBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface RedBookRepository extends JpaRepository<RedBook, Long> {
}
