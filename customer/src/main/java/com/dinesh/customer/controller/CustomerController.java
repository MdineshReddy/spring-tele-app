package com.dinesh.customer.controller;

import com.dinesh.customer.dto.CustomerDTO;
import com.dinesh.customer.dto.LoginDTO;
import com.dinesh.customer.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerController {
    private static final Log LOGGER = LogFactory.getLog(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerDTO customerDTO){
        LOGGER.info("Creation request for customer "+ customerDTO);
        customerService.createCustomer(customerDTO);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO loginDTO){
        LOGGER.info("Login request for customer "+loginDTO.getPhoneNo()+" with password "+loginDTO.getPassword());
        return customerService.login(loginDTO);
    }

    @GetMapping("/customers/{phoneNo}")
    public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {
        LOGGER.info("Profile request for customer "+ phoneNo);
        return customerService.getCustomerProfile(phoneNo);
    }
}
