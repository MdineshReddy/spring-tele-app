package com.dinesh.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @Column(name = "phone_no", nullable = false)
    Long phoneNo;
    @Column(nullable = false, length = 50)
    String name;
    @Column(nullable = false)
    Integer age;
    @Column(nullable = false, length = 50)
    String address;
    @Column(nullable = false, length = 50)
    String password;
    @Column(nullable = false, length = 1)
    char gender;

    @Column(name = "plan_id", nullable = false)
    int planId;

}
