import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Shofer implements Serializable {
    private String emri;
    private String mbiemri;
    private String emriSkuadres;

    public Shofer (String emri, String mbiemri, String emriSkuadres){
        setEmri(emri);
        setMbiemri(mbiemri);
        setEmriSkuadres(emriSkuadres);
    };


    public static void remove(int a){     //fshirja e nje skuadre
        Formula1Shofer.remove(a);
    }

    public static void rename (ArrayList<String> drivers, String skuadra){   //duke marr emrin e skuadres bejm ndrimin e shoferit

        int a = drivers.size();
        Scanner in=new Scanner(System.in);
        for(int i=0;i<=a;i++) {
            if (drivers.get(2).equals(skuadra)) {
                System.out.println("Vendos emrin e ri");
                String emri = in.next();
                drivers.set(0, emri);
                System.out.println("Vendos mbiemri e ri");
                String mbiemri = in.next();
                drivers.set(1, mbiemri);
            }
        }
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setEmriSkuadres(String emriSkuadres) {
        this.emriSkuadres = emriSkuadres;
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
