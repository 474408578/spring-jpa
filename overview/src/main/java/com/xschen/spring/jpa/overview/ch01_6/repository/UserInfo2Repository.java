package com.xschen.spring.jpa.overview.ch01_6.repository;

import com.xschen.spring.jpa.overview.ch01_6.domain.UserInfo2;
import com.xschen.spring.jpa.overview.ch01_6.domain.UserInfoId2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */
public interface UserInfo2Repository extends JpaRepository<UserInfo2, UserInfoId2> {

}
