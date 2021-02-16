package com.example.testTask4.controller;

import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    private  final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients/")
    public String clients(Model model) {
        List<ClientEntity> clientEntityArrayList = clientService.findAll();
        model.addAttribute("clients", clientEntityArrayList);
        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String deleteClient(@PathVariable String id, Model model) {
        clientService.delete(id);
        List<ClientEntity> clientEntityArrayList = clientService.findAll();
        model.addAttribute("clients",clientEntityArrayList);
        return "clients";
    }

    @GetMapping("/clients/update/{id}")
    public String toUpdateClient(@PathVariable String id, Model model) {
        ClientEntity clientEntity = clientService.findById(id);
        model.addAttribute("client",clientEntity);
        return "client";
    }

    @PostMapping("/clients/{id}")
    public String updateClient(@PathVariable String id,
                               @RequestParam(name="name") String name,
                               @RequestParam(name = "email", required = false, defaultValue = "") String email,
                               @RequestParam(name = "passport") String passport,
                               @RequestParam(name = "phone") String phone,
                               Model model) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setPassport(passport);
        clientEntity.setName(name);
        clientEntity.setEmail(email);
        clientEntity.setId(id);
        clientEntity.setPhone(phone);
        clientService.save(clientEntity);
        List<ClientEntity> clientEntityArrayList = clientService.findAll();
        model.addAttribute("clients",clientEntityArrayList);
        return "clients";
    }

    @PostMapping("/clients/")
    public String saveClient(@RequestParam(name="name") String name,
                             @RequestParam(name = "email", required = false, defaultValue = "") String email,
                             @RequestParam(name = "passport") String passport,
                             @RequestParam(name = "phone") String phone,
                             Model model) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setEmail(email);
        clientEntity.setName(name);
        clientEntity.setPassport(passport);
        clientEntity.setPhone(phone);
        clientService.save(clientEntity);
        List<ClientEntity> clientEntityArrayList = clientService.findAll();
        model.addAttribute("clients",clientEntityArrayList);
        return "clients";
    }

}
