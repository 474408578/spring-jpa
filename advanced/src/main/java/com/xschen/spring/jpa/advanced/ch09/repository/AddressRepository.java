package com.xschen.spring.jpa.advanced.ch09.repository;

import com.xschen.spring.jpa.advanced.ch09.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
