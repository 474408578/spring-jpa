package com.xschen.spring.jpa.overview.ch01_6.repository;

import com.xschen.spring.jpa.overview.ch01_6.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author xschen
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByNameAndEmail(String name, String email);

    /**
     * 利用 JPQL 动态查询用户信息
     * @param name
     * @param email
     * @return
     */
    @Query("SELECT u.name AS name, u.email AS email FROM User u " +
            "WHERE (u.name = :name) AND (u.email = :email)")
    User findByNameAndEmail2(@Param("name") String name, @Param("email") String email);
}
