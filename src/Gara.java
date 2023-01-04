import java.io.Serializable;

public class Gara implements Serializable {
    string data;
    string emriShoferit;
    string emriSkuadres;
    int pozicioni;

    Gara() {}; //konstruktori default
    Gara(string data, string emriShoferit, string emriSkuadres, int pozicioni){
        this.data = data;
        this.emriShoferit = emriShoferit;
        this.emriSkuadres = emriSkuadres;
        this.pozicioni = pozicioni;
    }

    public boolean addNewGara(string data, string emriShoferit, string emriSkuadres, int pozicioni){
        this.data = data;
        this.emriShoferit = emriShoferit;
        this.emriSkuadres = emriSkuadres;
        this.pozicioni = pozicioni;

        return true;
    }

    public string getData() {
        return data;
    }

    public int getPozicioni() {
        return pozicioni;
    }

    public string getEmriShoferit() {
        return emriShoferit;
    }

    public string getEmriSkuadres() {
        return emriSkuadres;
    }
}
