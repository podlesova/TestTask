package com.example.testTask4.controller;

import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.model.CreditEntity;
import com.example.testTask4.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/credits/")
    public String credits(Model model) {
        List<CreditEntity> creditEntityArrayList = creditService.findAll();
        model.addAttribute("credits", creditEntityArrayList);
        return "credits";
    }

    @GetMapping("/credits/{id}")
    public String deleteCredit(@PathVariable String id, Model model) {
        creditService.delete(id);
        List<CreditEntity> creditEntityArrayList = creditService.findAll();
        model.addAttribute("credits",creditEntityArrayList);
        return "credits";
    }

    @GetMapping("/credits/update/{id}")
    public String toUpdateCredit(@PathVariable String id, Model model) {
        CreditEntity creditEntity = creditService.findById(id);
        model.addAttribute("credit",creditEntity);
        return "credit";
    }

    @PostMapping("/credits/{id}")
    public String updateCredit(@PathVariable String id,
                               @RequestParam(name="limit") double limit,
                               @RequestParam(name = "percent") float percent,
                               Model model) {
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setLimit((int)limit);
        creditEntity.setPercent(percent);
        creditEntity.setId(id);
        creditService.save(creditEntity);
        List<CreditEntity> creditEntityArrayList = creditService.findAll();
        model.addAttribute("credits",creditEntityArrayList);
        return "credits";
    }

    @PostMapping("/credits/")
    public String saveClient(@RequestParam(name="limit") double limit,
                             @RequestParam(name = "percent") float percent,
                             Model model) {
        int intLimit = (int)Math.round(limit);
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setLimit(intLimit);
        creditEntity.setPercent(percent);
        creditService.save(creditEntity);
        List<CreditEntity> creditEntityArrayList = creditService.findAll();
        model.addAttribute("credits",creditEntityArrayList);
        return "credits";
    }

}
