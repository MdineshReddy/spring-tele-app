package com.dinesh.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendFamily {
    @Id
    @GeneratedValue
    int id;

    @Column(name = "phone_no")
    long phoneNo;

    @Column(name = "friend_and_family")
    long friendAndFamily;
}
