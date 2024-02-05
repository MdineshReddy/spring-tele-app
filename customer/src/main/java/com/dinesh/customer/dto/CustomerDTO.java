package com.dinesh.customer.dto;

import com.dinesh.customer.entity.Customer;
import com.dinesh.customer.entity.FriendFamily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private long phoneNo;
    private String name;
    private int age;
    private char gender;
    private List<Long> friendAndFamily;
    private String password;
    private String address;
    private PlanDTO currentPlan;

    // Converts Entity into DTO
    public static CustomerDTO valueOf(Customer customer){
        List<FriendFamily> friendFamilies = customer.getFriends();
        List<Long> friendList = new ArrayList<>();
        for(FriendFamily friendFamily: friendFamilies){
            friendList.add(friendFamily.getFriendAndFamily());
        }
        return CustomerDTO.builder().age(customer.getAge()).gender(customer.getGender()).name(customer.getName()).phoneNo(customer.getPhoneNo()).address(customer.getAddress()).friendAndFamily(friendList).build();
    }

    // Converts DTO into Entity
    public Customer createEntity() {
        Customer cust = new Customer();
        cust.setAge(this.getAge());
        cust.setGender(this.getGender());
        cust.setName(this.getName());
        cust.setPhoneNo(this.getPhoneNo());
        cust.setAddress(this.getAddress());
        cust.setPassword(this.getPassword());

        return Customer.builder().age(this.age).gender(this.gender).name(this.name).phoneNo(this.phoneNo).address(this.address).password(this.password).build();
    }
}
