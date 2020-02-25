package com.freedom.controller;

import com.freedom.entity.CustomerInfo;
import com.freedom.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerInfoController  {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @RequestMapping("/findAll")
    public List<CustomerInfo> findAll(){
        return customerInfoRepository.findAll();
    }
}
