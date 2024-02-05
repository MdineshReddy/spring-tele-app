package com.dinesh.friendfamily.repository;


import com.dinesh.friendfamily.entity.FriendFamily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendFamilyRepository extends JpaRepository<FriendFamily, Integer> {
    List<FriendFamily> findByPhoneNo(long phoneNo);
}
