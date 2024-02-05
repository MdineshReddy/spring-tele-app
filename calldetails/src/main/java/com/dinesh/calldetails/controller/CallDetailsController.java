package com.dinesh.calldetails.controller;

import com.dinesh.calldetails.dto.CallDetailsDTO;
import com.dinesh.calldetails.service.CallDetailsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CallDetailsController {
    private static final Log LOGGER = LogFactory.getLog(CallDetailsController.class);

    @Autowired
    private CallDetailsService callDetailsService;

    @GetMapping("/customers/{phoneNo}/calldetails")
    public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo){
        LOGGER.info("Calldetails request for customer "+ phoneNo);

        return callDetailsService.getCustomerCallDetails(phoneNo);
    }
}
