package com.dinesh.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plan {
    @Id
    @Column(name = "plan_id", nullable = false)
    Integer planId;
    @Column(name = "plan_name", nullable = false, length = 50)
    String planName;
    @Column(name = "national_rate", nullable = false)
    Integer nationalRate;
    @Column(name = "local_rate", nullable = false)
    Integer localRate;
}
