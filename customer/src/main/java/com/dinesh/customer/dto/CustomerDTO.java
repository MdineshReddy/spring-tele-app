package com.dinesh.customer.dto;

import com.dinesh.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        PlanDTO planDTO = PlanDTO.builder().planId(customer.getPlanId()).build();
        return CustomerDTO.builder().age(customer.getAge()).gender(customer.getGender()).name(customer.getName()).phoneNo(customer.getPhoneNo()).address(customer.getAddress()).currentPlan(planDTO).build();
    }

    // Converts DTO into Entity
    public Customer createEntity() {
        return Customer.builder().age(this.age).gender(this.gender).name(this.name).phoneNo(this.phoneNo).address(this.address).password(this.password).planId(this.currentPlan.getPlanId()).build();
    }
}
