package com.dinesh.customer.service;

import com.dinesh.customer.dto.CustomerDTO;
import com.dinesh.customer.dto.LoginDTO;
import com.dinesh.customer.entity.Customer;
import com.dinesh.customer.repository.CustomerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private static final Log LOGGER = LogFactory.getLog(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(CustomerDTO customerDTO) {
        LOGGER.info("Creation request for customer "+ customerDTO);
        Customer cust = customerDTO.createEntity();
        customerRepository.save(cust);
    }


    public boolean login(LoginDTO loginDTO) {
        Customer customer = null;
        LOGGER.info("Login Request For Customer "+ +loginDTO.getPhoneNo() +" with password "+loginDTO.getPassword());
        Optional<Customer> optCust = customerRepository.findById(loginDTO.getPhoneNo());
        if (optCust.isPresent()) {
            customer = optCust.get();
            if (customer.getPassword().equals(loginDTO.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public CustomerDTO getCustomerProfile(Long phoneNo) {
        CustomerDTO custDTO = null;
        LOGGER.info("Profile request for customer "+ phoneNo);
        Optional<Customer> optCust = customerRepository.findById(phoneNo);
        if (optCust.isPresent()) {
            Customer cust = optCust.get();
            custDTO = CustomerDTO.valueOf(cust);
        }

        LOGGER.info("Profile for customer : "+ custDTO);
        return custDTO;
    }
}
