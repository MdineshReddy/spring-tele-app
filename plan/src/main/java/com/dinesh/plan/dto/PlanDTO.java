package com.dinesh.plan.dto;

import com.dinesh.plan.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {
    Integer planId;

    String planName;

    Integer nationalRate;

    Integer localRate;

    // Converts Entity into DTO
    public static PlanDTO valueOf(Plan plan) {
        return PlanDTO.builder().localRate(plan.getLocalRate()).nationalRate(plan.getNationalRate()).planId(plan.getPlanId()).planName(plan.getPlanName()).build();
    }
}
