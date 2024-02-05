package com.dinesh.friendfamily.dto;

import com.dinesh.friendfamily.entity.FriendFamily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendFamilyDTO {
    long phoneNo;
    long friendAndFamily;

    // Converts DTO into Entity
    public FriendFamily createFriend() {
        return FriendFamily.builder().phoneNo(this.getPhoneNo()).friendAndFamily(this.getFriendAndFamily()).build();
    }
}
