import java.io.Serializable;

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

    public boolean add(String data, String emriShoferit, String emriSkuadres, int pozicioni){
        this.data = data;
        this.emriShoferit = emriShoferit;
        this.emriSkuadres = emriSkuadres;
        this.pozicioni = pozicioni;

        return true;
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
