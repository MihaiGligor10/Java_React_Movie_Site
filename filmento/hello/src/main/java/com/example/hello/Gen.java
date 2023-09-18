package com.example.hello;

public class Gen {
    private int ID_Gen;
    private String gen;

    public Gen(int ID_Gen, String gen) {
        this.ID_Gen = ID_Gen;
        this.gen = gen;
    }

    public int getID_Gen() {
        return ID_Gen;
    }

    public void setID_Gen(int ID_Gen) {
        this.ID_Gen = ID_Gen;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}
