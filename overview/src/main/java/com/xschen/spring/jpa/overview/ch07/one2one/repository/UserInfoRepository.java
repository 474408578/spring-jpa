package com.xschen.spring.jpa.overview.ch07.one2one.repository;

import com.xschen.spring.jpa.overview.ch07.one2one.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
