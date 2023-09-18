package ps2.PS2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps2.PS2.service.impl.ClientServiceImpl;

@RestController
public class ClientController {

    private final ClientServiceImpl clientService;

    public ClientController( ClientServiceImpl clientService) {
        this.clientService = clientService;
    }


    @RequestMapping("/deleteClient")
    @PostMapping
    public ResponseEntity deleteClient(@RequestBody String email){
        System.out.println(email+"pentru stergere client");
        try
        {
            clientService.deleteClientByEmail(email);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

