package com.dinesh.plan.controller;

import com.dinesh.plan.dto.PlanDTO;
import com.dinesh.plan.service.PlanService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PlanController {
    private static final Log LOGGER  = LogFactory.getLog(PlanService.class);
    @Autowired
    private PlanService planService;

    // Fetches all plan details
    @GetMapping("/plans")
    public List<PlanDTO> getAllPlans() {
        return planService.getAllPlans();
    }
    // To get a plan details based on plan id
    @GetMapping("/plans/{planId}")
    public PlanDTO getPlan(@PathVariable("planId") Integer planId) {
        return planService.getPlan(planId);
    }


}

