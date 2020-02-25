package com.freedom.repository;

import com.freedom.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer> {
}
