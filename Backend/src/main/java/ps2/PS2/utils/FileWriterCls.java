package ps2.PS2.utils;

import lombok.*;
import ps2.PS2.model.Movie;

import javax.persistence.Entity;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Getter
@Setter
public class FileWriterCls {

    private static FileWriterCls single_instance = null;


    private FileWriterCls()
    {
    }

    public static FileWriterCls getInstance()
    {
        if (single_instance == null)
            single_instance = new FileWriterCls();

        return single_instance;
    }

    public void generateTXT(String client, List<Movie> m){
        try {
            File myObj = new File(client+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(client+".txt");
            for(int i=0;i<m.size();i++)
            {
                myWriter.write("Nume: "+m.get(i).getNumeM()+"\n"+"Gen: "+m.get(i).getGen()+"\n"+"Descriere: "+m.get(i).getDescriere()+"\n\n\n");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
