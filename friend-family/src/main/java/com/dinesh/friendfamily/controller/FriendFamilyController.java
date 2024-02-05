package com.dinesh.friendfamily.controller;

import com.dinesh.friendfamily.dto.FriendFamilyDTO;
import com.dinesh.friendfamily.service.FriendFamilyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FriendFamilyController {
    private static final Log LOGGER = LogFactory.getLog(FriendFamilyController.class);

    @Autowired
    FriendFamilyService friendService;

    @PostMapping("/customers/{phoneNo}/friends")
    public void saveFriend(@PathVariable Long phoneNo, @RequestBody FriendFamilyDTO friendDTO) {
        LOGGER.info("Creation request for customer "+phoneNo+" with data "+ friendDTO);
        friendService.saveFriend(phoneNo, friendDTO);
    }
}
