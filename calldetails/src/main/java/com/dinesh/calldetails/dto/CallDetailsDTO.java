package com.dinesh.calldetails.dto;

import com.dinesh.calldetails.entity.CallDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallDetailsDTO {
    private long calledBy;
    private long calledTo;
    private Date calledOn;
    private int duration;

    // Converts Entity into DTO
    public static CallDetailsDTO valueOf(CallDetails callDetails) {
        return CallDetailsDTO.builder().calledBy(callDetails.getCalledBy()).calledOn(callDetails.getCalledOn()).calledTo(callDetails.getCalledTo()).duration(callDetails.getDuration()).build();
    }
}
