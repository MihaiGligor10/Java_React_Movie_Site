package ps2.PS2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ps2.PS2.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByEmailAndParola(String email,  String parola);
    Client findClientByEmail(String email);
    Boolean existsByEmail(String e);
    Client findById(int id);
    void deleteClientByEmail(String e);
}