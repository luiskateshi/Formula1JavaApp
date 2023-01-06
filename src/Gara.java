import java.io.Serializable;
import java.util.ArrayList;

public class Gara implements Serializable {
    String data;
    String emriShoferit;
    String emriSkuadres;
    int pozicioni;

    Gara() {}; //konstruktori default
    Gara(String data, String emriShoferit, String emriSkuadres, int pozicioni){
        this.data = data;
        this.emriShoferit = emriShoferit;
        this.emriSkuadres = emriSkuadres;
        this.pozicioni = pozicioni;
    }

    public static void addRace(ArrayList<Gara> races, String data, String emriShoferit, String emriSkuadres, int pozicioni){
        Gara g = new Gara(data, emriShoferit, emriSkuadres, pozicioni);
        races.add(g);
    }

    public String getData() {
        return data;
    }

    public int getPozicioni() {
        return pozicioni;
    }

    public String getEmriShoferit() {
        return emriShoferit;
    }

    public String getEmriSkuadres() {
        return emriSkuadres;
    }
}
