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


    public static void remove(ArrayList<Formula1Shofer> drivers){     //fshirja e nje skuadre
        Scanner in=new Scanner(System.in);
        System.out.println("Zgjidh shoferin qe deshironi te fshini sipas numrit ne te majte: ");
        int i = 0;
        for (Formula1Shofer x : drivers) {
            System.out.println(i + " - " + x.getEmri().toString() + " " + x.getMbiemri().toString() + " " + x.getEmriSkuadres().toString());
            i++;
        }
        int a = in.nextInt();
        drivers.remove(a);
    }


    public static void rename (ArrayList<Formula1Shofer> drivers){   //duke marr emrin e skuadres bejm ndrimin e shoferit
        Scanner in=new Scanner(System.in);
        System.out.println("Vendos emrin e skuadres");
        String skuadra = in.next();
        int a = drivers.size();
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
