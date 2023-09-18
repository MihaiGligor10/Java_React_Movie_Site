package ps2.PS2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.AuthDTO;
import ps2.PS2.model.Client;


@Component
public interface ClientService {
Client addClient(AuthDTO client) ;
void deleteClientByEmail(String e);
Client validateClient(AuthDTO authDTO);
Boolean doesEmailExists(String email);
Client findClientById(int id);
}
