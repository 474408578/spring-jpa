package com.xschen.spring.jpa.overview.ch07.one2many.repository;

import com.xschen.spring.jpa.overview.ch07.one2many.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
