package com.dinesh.friendfamily.service;

import com.dinesh.friendfamily.dto.FriendFamilyDTO;
import com.dinesh.friendfamily.entity.FriendFamily;
import com.dinesh.friendfamily.repository.FriendFamilyRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendFamilyService {
    private static final Log LOGGER = LogFactory.getLog(FriendFamilyService.class);

    @Autowired
    FriendFamilyRepository friendFamilyRepository;


    public void saveFriend(Long phoneNo, FriendFamilyDTO friendDTO) {
        LOGGER.info("Creation request for customer "+phoneNo+" with data "+ friendDTO);
        friendDTO.setPhoneNo(phoneNo);
        FriendFamily friend = friendDTO.createFriend();
        friendFamilyRepository.save(friend);
    }
}
