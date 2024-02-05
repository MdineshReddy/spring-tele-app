package com.dinesh.plan.service;

import com.dinesh.plan.dto.PlanDTO;
import com.dinesh.plan.entity.Plan;
import com.dinesh.plan.repository.PlanRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private static final Log LOGGER = LogFactory.getLog(PlanService.class);

    @Autowired
    private PlanRepository planRepository;



    public List<PlanDTO> getAllPlans() {
        List<Plan> plans = planRepository.findAll();
        List<PlanDTO> planDTOs = new ArrayList<>();

        for (Plan plan : plans) {
            PlanDTO planDTO = PlanDTO.valueOf(plan);
            planDTOs.add(planDTO);
        }

        LOGGER.info("Plan details : "+ planDTOs);
        return planDTOs;
    }


    public PlanDTO getPlan(Integer planId) {
        PlanDTO planDTO = null;
        Optional<Plan> optPlan = planRepository.findById(planId);
        if (optPlan.isPresent()) {
            Plan plan = optPlan.get();
            planDTO = PlanDTO.valueOf(plan);
        }

        return planDTO;
    }
}
