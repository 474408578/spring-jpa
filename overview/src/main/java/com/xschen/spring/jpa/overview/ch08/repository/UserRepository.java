package com.xschen.spring.jpa.overview.ch08.repository;

import com.xschen.spring.jpa.overview.ch08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
