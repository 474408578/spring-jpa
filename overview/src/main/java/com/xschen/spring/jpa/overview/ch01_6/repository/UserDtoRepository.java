package com.xschen.spring.jpa.overview.ch01_6.repository;

import com.xschen.spring.jpa.overview.ch01_6.domain.User;
import com.xschen.spring.jpa.overview.ch01_6.domain.UserDto;
import com.xschen.spring.jpa.overview.ch01_6.domain.UserSimpleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author xschen
 */

public interface UserDtoRepository extends JpaRepository<User, Long> {
    /**
     * 查询 user 表中的 name, email, 和 UserExtend 表中的idCard
     * @param id
     * @return
     */
    @Query("SELECT u.name, u.email, e.idCard FROM User u, UserExtend e " +
            "WHERE u.id = e.userId AND u.id = :id")
    List<Object[]> findByUserDtoId1(@Param("id") Long id);


    /**
     * 直接通过构造函数 new UserDto()
     * @param id
     * @return
     */
    @Query("SELECT new com.xschen.spring.jpa.overview.ch1_6.domain.UserDto(CONCAT(u.name, '123'), u.email, e.idCard) " +
            "FROM User u, UserExtend e WHERE u.id = e.userId AND u.id = :id")
    UserDto findByUserDtoId2(@Param("id") Long id);

    /**
     * 利用 UserDto 接口获得我们想要的结果
     * @param id
     * @return
     */
    @Query("SELECT CONCAT(u.name, '123') AS name, UPPER(u.email) AS email, e.idCard AS idCard " +
            "FROM User u, UserExtend e WHERE u.id = e.userId AND u.id = :id")
    UserSimpleDto findByUserDtoId3(@Param("id") Long id);
}
