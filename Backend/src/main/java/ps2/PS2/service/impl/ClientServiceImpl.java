package ps2.PS2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.AuthDTO;
import ps2.PS2.model.Client;
import ps2.PS2.repository.ClientRepository;
import ps2.PS2.service.ClientService;

import javax.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    Client client0=new Client("0","0");
   // @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }




    @Override
    @Transactional
    public void deleteClientByEmail(String e) {
        try {
            clientRepository.deleteClientByEmail(e);
        }catch (Exception a)
        {
            System.out.println("error \n client might not exist");
        }
    }

    @Override
    public Client validateClient(AuthDTO authDTO) {
        //System.out.println(clientRepository.findClientByEmailAndParola(authDTO.getEmail(), authDTO.getParola()) + " implementare ");
            return clientRepository.findClientByEmailAndParola(authDTO.getEmail(), authDTO.getParola());
    }


    @Override
    public Boolean doesEmailExists(String email) {
           return clientRepository.existsByEmail(email);
    }

    @Override
    public Client addClient(AuthDTO client) {
        System.out.println(client);
        if(doesEmailExists(client.getEmail()))
        {
            return client0;
        }else
        {
            Client c=new Client(client.getEmail(), client.getParola());
            return clientRepository.save(c);
        }

    }

    @Override
    public Client findClientById(int id) {
        if(clientRepository.findById(id)==null)
        {
            return new Client("0","0");
        }
        else
        {
            return clientRepository.findById(id);
        }
    }

}
