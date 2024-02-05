package com.dinesh.customer.dto;

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
}
