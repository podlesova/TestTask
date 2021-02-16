package com.example.testTask4.controller;

import com.example.testTask4.model.BankEntity;
import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.model.CreditEntity;
import com.example.testTask4.service.BankService;
import com.example.testTask4.service.ClientService;
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
public class BankController {

    private  final BankService bankService;
    private  final CreditService creditService;
    private  final ClientService clientService;

    @Autowired
    public BankController(BankService bankService, CreditService creditService, ClientService clientService) {
        this.bankService = bankService;
        this.creditService = creditService;
        this.clientService = clientService;
    }

    @GetMapping("/banks/update/{id}")
    public String toUpdateBank(@PathVariable String id, Model model) {
        BankEntity bankEntity = bankService.findById(id);
        List<CreditEntity> creditEntities = creditService.findAll();
        List<ClientEntity> clientEntities = clientService.findAll();
        model.addAttribute("credits",creditEntities);
        model.addAttribute("clients",clientEntities);
        model.addAttribute("bank",bankEntity);
        return "bank";
    }

    @PostMapping("/banks/{id}")
    public String updateClient(@PathVariable String id,
                               @RequestParam(name="id_client") String id_client,
                               @RequestParam(name = "id_credit") String id_credit,
                               Model model) {
        BankEntity bankEntity = new BankEntity();
        ClientEntity clientEntity = clientService.findById(id_client);
        CreditEntity creditEntity = creditService.findById(id_credit);
        bankEntity.setId(id);
        bankEntity.setId_credit(creditEntity);
        bankEntity.setId_client(clientEntity);
        bankService.save(bankEntity);
        setModel(model);
        return "banks";
    }

    @GetMapping("/banks/")
    public String banks(Model model) {
        setModel(model);
        return "banks";
    }
    @GetMapping("/banks/{id}")
    public String deleteBank(@PathVariable String id, Model model) {
        bankService.delete(id);
        setModel(model);
        return "banks";
    }

    @PostMapping("/banks/")
    public String saveBank(@RequestParam(name="id_client") String id_client,
                           @RequestParam(name="id_credit") String id_credit,
                           Model model) {
        BankEntity bankEntity = new BankEntity();
        ClientEntity clientEntity = clientService.findById(id_client);
        CreditEntity creditEntity = creditService.findById(id_credit);
        bankEntity.setId_client(clientEntity);
        bankEntity.setId_credit(creditEntity);
        bankService.save(bankEntity);
        setModel(model);
        return "banks";
    }

    private void setModel(Model model){
        List<BankEntity> bankEntityArrayList = bankService.findAll();
        List<CreditEntity> creditEntities = creditService.findAll();
        List<ClientEntity> clientEntities = clientService.findAll();
        model.addAttribute("banks",bankEntityArrayList);
        model.addAttribute("credits",creditEntities);
        model.addAttribute("clients",clientEntities);
    }

}
