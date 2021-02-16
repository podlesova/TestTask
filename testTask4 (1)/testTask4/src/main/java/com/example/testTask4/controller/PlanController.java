package com.example.testTask4.controller;

import com.example.testTask4.model.PlanEntity;
import com.example.testTask4.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/plans/{id}")
    public String plans(@PathVariable String id, Model model) {
        List<PlanEntity> planEntities = planService.findByCreditOffer(id);
        BigDecimal totalSum = BigDecimal.valueOf(0), bodySum = BigDecimal.valueOf(0), percentSum = BigDecimal.valueOf(0);
        for (PlanEntity planEntity: planEntities){
           totalSum = totalSum.add(planEntity.getTotalSum());
           bodySum = bodySum.add(planEntity.getCreditBodySum());
           percentSum = percentSum.add(planEntity.getPercentBodySum());
        }
        model.addAttribute("plans", planEntities);
        model.addAttribute("totalSum", totalSum);
        model.addAttribute("bodySum", bodySum);
        model.addAttribute("percentSum", percentSum);
        return "plans";
    }
}
