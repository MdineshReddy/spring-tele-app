package com.dinesh.calldetails.service;

import com.dinesh.calldetails.dto.CallDetailsDTO;
import com.dinesh.calldetails.entity.CallDetails;
import com.dinesh.calldetails.repository.CallDetailsRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallDetailsService {
    private static final Log LOGGER = LogFactory.getLog(CallDetailsService.class);

    @Autowired
    private CallDetailsRepository callDetailsRepository;


    public List<CallDetailsDTO> getCustomerCallDetails(long phoneNo) {
        LOGGER.info("Calldetails request for customer "+ phoneNo);

        List<CallDetails> callDetails = callDetailsRepository.findByCalledBy(phoneNo);
        List<CallDetailsDTO> callsDTO = new ArrayList<>();

        for (CallDetails call : callDetails) {
            callsDTO.add(CallDetailsDTO.valueOf(call));
        }
        LOGGER.info("Calldetails for customer : "+ callDetails);

        return callsDTO;
    }
}
