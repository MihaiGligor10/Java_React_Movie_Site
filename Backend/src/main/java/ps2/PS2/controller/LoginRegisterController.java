package ps2.PS2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ps2.PS2.dto.AuthDTO;
import ps2.PS2.service.ClientService;

//@CrossOrigin
@RestController
public class LoginRegisterController {

    private final ClientService clientService;

    public LoginRegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity login(@RequestBody AuthDTO auth){
        System.out.println(auth + "pentru login");
        return ResponseEntity.status(HttpStatus.OK).body(clientService.validateClient(auth));

    }


    @RequestMapping("/register")
    @PostMapping
    public ResponseEntity register(@RequestBody AuthDTO authDTO){
        System.out.println(authDTO+"pentru register");
        return ResponseEntity.status(HttpStatus.OK).body(clientService.addClient(authDTO));
    }
}
