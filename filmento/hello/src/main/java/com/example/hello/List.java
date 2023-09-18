package com.example.hello;

public class List {
    private int ID_Client;
    private int ID_Movie;

    public List(int ID_Client, int ID_Movie) {
        this.ID_Client = ID_Client;
        this.ID_Movie = ID_Movie;
    }

    public int getID_Client() {
        return ID_Client;
    }

    public void setID_Client(int ID_Client) {
        this.ID_Client = ID_Client;
    }

    public int getID_Movie() {
        return ID_Movie;
    }

    public void setID_Movie(int ID_Movie) {
        this.ID_Movie = ID_Movie;
    }
}
