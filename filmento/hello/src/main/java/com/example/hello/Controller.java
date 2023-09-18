package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/Clients")
public class Controller {
    private final ClientService clientService;

    @Autowired
    public Controller(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getClients(){
        return clientService.getClients();
    }
}
