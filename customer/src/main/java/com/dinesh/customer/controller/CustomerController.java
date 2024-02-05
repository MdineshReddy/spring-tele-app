package com.dinesh.customer.controller;

import com.dinesh.customer.dto.CustomerDTO;
import com.dinesh.customer.dto.LoginDTO;
import com.dinesh.customer.dto.PlanDTO;
import com.dinesh.customer.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    private static final Log LOGGER = LogFactory.getLog(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        LOGGER.info("Creation request for customer " + customerDTO);
        customerService.createCustomer(customerDTO);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO loginDTO) {
        LOGGER.info("Login request for customer " + loginDTO.getPhoneNo() + " with password " + loginDTO.getPassword());
        return customerService.login(loginDTO);
    }

    @GetMapping("/customers/{phoneNo}")
    public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {
        LOGGER.info("Profile request for customer " + phoneNo);
        CustomerDTO customerDTO = customerService.getCustomerProfile(phoneNo);
        PlanDTO planDTO = new RestTemplate().getForObject("http://localhost:9400/plans/" + customerDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
        customerDTO.setCurrentPlan(planDTO);
        List<Long> friendsAndFamily = new RestTemplate().getForObject("http://localhost:9300/customers/"+customerDTO.getPhoneNo()+"/friends", List.class);
        customerDTO.setFriendAndFamily(friendsAndFamily);
        return customerDTO;
    }
}
