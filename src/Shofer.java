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

    public static void rename (ArrayList<Formula1Shofer> drivers, String skuadra){   //duke marr emrin e skuadres bejm ndrimin e shoferit

        int a = drivers.size();
        Scanner in=new Scanner(System.in);
        for(int i=0;i<=a;i++) {
            Formula1Shofer temp = drivers.get(i);
            if (drivers.get(i).getEmriSkuadres().equalsIgnoreCase(skuadra)) {
                System.out.println("Vendos emrin e ri");
                String emri = in.next();
                temp.setEmri(emri);
                System.out.println("Vendos mbiemri e ri");
                String mbiemri = in.next();
                temp.setMbiemri(mbiemri);
                drivers.set(i, temp);
                return;
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
