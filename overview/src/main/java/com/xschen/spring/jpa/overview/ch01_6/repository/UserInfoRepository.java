package com.xschen.spring.jpa.overview.ch01_6.repository;

import com.xschen.spring.jpa.overview.ch01_6.domain.UserInfo;
import com.xschen.spring.jpa.overview.ch01_6.domain.UserInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */

public interface UserInfoRepository extends JpaRepository<UserInfo, UserInfoId> {
}
