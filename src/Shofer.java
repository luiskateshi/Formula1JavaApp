import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Shofer implements Serializable {
    String emri;
    String mbiemri;
    String emriSkuadres;


    Shofer (){};
    Shofer (String emri, String mbiemri, String emriSkuadres){
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.emriSkuadres = emriSkuadres;
    };

    public static void addShofer(ArrayList<Shofer> shoferet, String emri, String mbiemri, String emriSkuadres){
        Shofer s = new Shofer( emri, mbiemri, emriSkuadres);
        shoferet.add(s);
    }

    public static void removeShofer( String emri) {

    //    Shofer.remove(emri);
    }



    public String getEmri(){
        return emri;
    }
    public String getMbiemri(){
        return mbiemri;
    }
    public String getEmriSkuadres(){
        return emriSkuadres;
    }
}
