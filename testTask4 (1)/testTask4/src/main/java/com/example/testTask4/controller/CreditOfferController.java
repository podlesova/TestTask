package com.example.testTask4.controller;

import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.model.CreditEntity;
import com.example.testTask4.model.CreditOfferEntity;
import com.example.testTask4.model.PlanEntity;
import com.example.testTask4.service.ClientService;
import com.example.testTask4.service.CreditOfferService;
import com.example.testTask4.service.CreditService;
import com.example.testTask4.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreditOfferController {

    private  final CreditOfferService creditOfferService;
    private  final CreditService creditService;
    private  final ClientService clientService;
    private  final PlanService planService;

    @Autowired
    public CreditOfferController(CreditOfferService creditOfferService, CreditService creditService, ClientService clientService, PlanService planService) {
        this.creditOfferService = creditOfferService;
        this.creditService = creditService;
        this.clientService = clientService;
        this.planService = planService;
    }




    @GetMapping("/creditoffers/")
    public String creditoffers(Model model) {
        setModel(model);
        return "creditoffers";
    }

    @GetMapping("/creditoffers/{id}")
    public String deleteCreditOffer(@PathVariable String id, Model model) {
        creditOfferService.delete(id);
        setModel(model);
        return "creditoffers";
    }

    @PostMapping("/creditoffers/")
    public String saveCreditOffer(@RequestParam(name="id_client") String id_client,
                                  @RequestParam(name="id_credit") String id_credit,
                                  @RequestParam(name="sum") double sum,
                                  @RequestParam(name="months") double months,
                                  Model model) {
        int intMonths = (int)months;
        int intSum = (int)sum;
                CreditEntity creditEntity = creditService.findById(id_credit);
        if (creditEntity.getLimit() < sum){
            setModel(model);
            model.addAttribute("error","Cумма кредита больше лимита");
            return "creditoffers";
        }
        ClientEntity clientEntity = clientService.findById(id_client);
        CreditOfferEntity creditOfferEntity = new CreditOfferEntity();
        creditOfferEntity.setClient(clientEntity);
        creditOfferEntity.setCredit(creditEntity);
        creditOfferEntity.setCreditSum(intSum);
        CreditOfferEntity creditOfferEntity1 = creditOfferService.save(creditOfferEntity);
        savePlan(intSum, intMonths, creditEntity.getPercent(),creditOfferEntity1);
        setModel(model);
        return "creditoffers";
    }

    private void savePlan(int sum, int months, float percent, CreditOfferEntity creditOfferEntity){
        int value = Math.round(sum*(1200 + months * percent)/(1200 * months));
        BigDecimal sumPerMonth = BigDecimal.valueOf(value); // отдавать в месяц
        value =  Math.round(sum * months * percent / 1200 + sum);
        BigDecimal sumWithPercent = BigDecimal.valueOf(value);//общая сумма с процентом
        BigDecimal creditPerMonth = BigDecimal.valueOf(sum / (double)months).setScale(2,BigDecimal.ROUND_DOWN);//сумма погашения тела кредита в месяц
        BigDecimal percentPerMonth = sumPerMonth.subtract(creditPerMonth); //сумма погашения процента в месяц
        List<PlanEntity> planEntities = new ArrayList<>();
        LocalDate data = LocalDate.now();
        BigDecimal totalSum = BigDecimal.valueOf(0);
        BigDecimal totalCredit = BigDecimal.valueOf(0);
        BigDecimal totalPercent = BigDecimal.valueOf(0);
        for (int i = 1; i < months; i++){

            PlanEntity planEntity = new PlanEntity();
            planEntity.setCreditOffer(creditOfferEntity);
            planEntity.setCreditBodySum(creditPerMonth);
            planEntity.setPercentBodySum(percentPerMonth);
            planEntity.setTotalSum(sumPerMonth);
            planEntity.setDate(java.sql.Date.valueOf(data));
            planEntities.add(planEntity);
            data = data.plusMonths(1);
            totalSum = totalSum.add(sumPerMonth);
            totalCredit = totalCredit.add(creditPerMonth);
            totalPercent = totalPercent.add(percentPerMonth);
        }
        PlanEntity planEntity = new PlanEntity();
        planEntity.setCreditOffer(creditOfferEntity);
        BigDecimal lastValue = BigDecimal.valueOf(sum).subtract(totalCredit);
        planEntity.setCreditBodySum(lastValue);
        planEntity.setPercentBodySum(sumWithPercent.subtract(totalSum).subtract(lastValue));
        planEntity.setTotalSum(sumWithPercent.subtract(totalSum));
        planEntity.setDate(java.sql.Date.valueOf(data));
        planEntities.add(planEntity);
        planService.saveAll(planEntities);
    }

    private void setModel(Model model){
        List<CreditOfferEntity> creditOfferEntityArrayList = creditOfferService.findAll();
        List<CreditEntity> creditEntities = creditService.findAll();
        List<ClientEntity> clientEntities = clientService.findAll();
        model.addAttribute("credits",creditEntities);
        model.addAttribute("clients",clientEntities);
        model.addAttribute("creditoffers", creditOfferEntityArrayList);
        model.addAttribute("error","");
    }
}
