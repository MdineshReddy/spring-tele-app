package com.dinesh.friendfamily.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;

@Entity
@Table(name = "friendfamily")
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
