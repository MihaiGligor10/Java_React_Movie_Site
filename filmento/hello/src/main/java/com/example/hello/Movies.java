package com.example.hello;

public class Movies {
    private int ID_Movie;
    private int ID_Gen;
    private String nume;

    public Movies(int ID_Movie, int ID_Gen, String nume) {
        this.ID_Movie = ID_Movie;
        this.ID_Gen = ID_Gen;
        this.nume = nume;
    }

    public int getID_Movie() {
        return ID_Movie;
    }

    public int getID_Gen() {
        return ID_Gen;
    }

    public String getNume() {
        return nume;
    }

    public void setID_Movie(int ID_Movie) {
        this.ID_Movie = ID_Movie;
    }

    public void setID_Gen(int ID_Gen) {
        this.ID_Gen = ID_Gen;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
