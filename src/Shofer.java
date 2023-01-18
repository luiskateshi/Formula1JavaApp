import java.io.Serializable;
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

    public static void addShofer(String emri, String mbiemri, String emriSkuadres){
        Shofer s = new Shofer( emri, mbiemri, emriSkuadres);
        shoferet.add(s);
    }

    public static void removeShofer( String e) {

        shoferet.remove(e);
    }

    public static void renameShofer( String e) {
        Scanner input = new Scanner(System.in);
        removeShofer(e);

        System.out.println("emrin e ri: ");
        String emri = input.next();
        System.out.println("mbiemri e ri: ");
        String mbiemri = input.next();
        System.out.println("emrin skuadres e ri: ");
        String emriSkuadres = input.next();

        addShofer(emri,mbiemri,emriSkuadres);

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
