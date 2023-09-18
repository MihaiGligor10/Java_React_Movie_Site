package com.example.hello;

import javax.persistence.*;

@Entity
@Table
public class Clients {
    @Id
    @SequenceGenerator(
        name="client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private int ID_Client;
    private String email;
    private String parola;



    public Clients(int ID_Client, String email, String parola) {
        this.ID_Client = ID_Client;
        this.email = email;
        this.parola = parola;
    }

    public Clients() {

    }

    public int getID_Client() {
        return ID_Client;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    public void setID_Client(int ID_Client) {
        this.ID_Client = ID_Client;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Clients(String email, String parola) {
        this.email = email;
        this.parola = parola;
    }
}
