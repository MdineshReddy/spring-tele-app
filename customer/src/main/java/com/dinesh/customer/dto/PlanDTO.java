package com.dinesh.customer.dto;

import com.dinesh.customer.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {
    private Integer planId;

    private String planName;

    private Integer nationalRate;

    private Integer localRate;

    // Converts Entity into DTO
    public static PlanDTO valueOf(Plan plan){
        return PlanDTO.builder().localRate(plan.getLocalRate()).nationalRate(plan.getNationalRate()).planId(plan.getPlanId()).planName(plan.getPlanName()).build();
    }
}
