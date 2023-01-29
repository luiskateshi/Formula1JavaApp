
import java.util.*;


//hello world
public class Formula1Shofer extends Shofer {
    private int nrVendeTePara;
    private int nrVendeTeDyta;
    private int nrVendeTeTreta;
    private int ActualPoints;
    private int nrGarave;
    private String vendndodhja;

    public Formula1Shofer(String emri, String mbiemri, String emriSkuadres) {
        super(emri, mbiemri, emriSkuadres);
        this.nrVendeTePara = 0;
        this.nrVendeTeDyta = 0;
        this.nrVendeTeTreta = 0;
        this.ActualPoints = 0;
        this.nrGarave = 0;
        this.vendndodhja = " ";
    }


    public Formula1Shofer(String emri, String mbiemri, String emriSkuadres,
                          int nrVendeTePara, int nrVendeTeDyta, int nrVendeTeTreta,
                          int actualPoints, int nrGarave, String vendndodhja) {
        super(emri, mbiemri, emriSkuadres);
        this.nrVendeTePara = nrVendeTePara;
        this.nrVendeTeDyta = nrVendeTeDyta;
        this.nrVendeTeTreta = nrVendeTeTreta;
        this.ActualPoints = actualPoints;
        this.nrGarave = nrGarave;
        this.vendndodhja = vendndodhja;
    }

    public static void addDriverToArrayList(ArrayList<Formula1Shofer> drivers){
        String emri;
        String mbiemri;
        String emriSkuadres;
        Scanner in = new Scanner(System.in);
        System.out.println("Vendos emrin e shoferit");
        emri = in.next();
        System.out.println("Vendos mbiemrin e shoferit");
        mbiemri = in.next();
        System.out.println("Vendos emrin e skuadres");
        emriSkuadres = in.next();

        var shoferi = new Formula1Shofer(emri, mbiemri, emriSkuadres);
        drivers.add(shoferi);
    }

    public static void ShfaqStatistikaShoferi(ArrayList<Formula1Shofer> drivers){
        Scanner in=new Scanner(System.in);
        System.out.println("Zgjidh shoferin per te cilin deshironi te shfaqni statistikat sipas numrit ne te majte: ");
        int i = 0;
        for (Formula1Shofer x : drivers) {
            System.out.println(i + " - " + x.getEmri() + " " + x.getMbiemri() + " " + x.getEmriSkuadres());
            i++;
        }
        int zgjedhja = in.nextInt();
        Formula1Shofer z = drivers.get(zgjedhja);
        System.out.println(z);
    }

    public static void SortShoferetByActualPointsDESC(ArrayList<Formula1Shofer> shoferi){
        shoferi.sort(new Formula1ShoferComparatorByActualPoints());
    }

    public static void SortShoferetByActualPointsASC(ArrayList<Formula1Shofer> shoferi){
        shoferi.sort(Collections.reverseOrder(new Formula1ShoferComparatorByActualPoints()));
    }

    public static void SortShoferetByNrVendeTeParaDESC(ArrayList<Formula1Shofer> shoferi){
        shoferi.sort(new Formula1ShoferComparatorByNrVendeTePara());
    }

    public static void ShfaqStatistikaTeGjitheShoferet(ArrayList<Formula1Shofer> shoferi){
        for (Formula1Shofer z : shoferi)
            System.out.println(z);
    }

    public int getActualPoints(){
        return ActualPoints;
    }

    public int getNrVendeTePara(){
        return nrVendeTePara;
    }

    public int getNrVendeTeDyta(){ return nrVendeTeDyta; }

    public int getNrVendeTeTreta() { return nrVendeTeTreta; }

    public int getNrGarave() { return nrGarave; }

    public String getVendndodhja() {
        return vendndodhja;
    }

    @Override
    public String toString() {
        return "Emri: " + getEmri() + "\t" + "Mbiemri: " + getMbiemri() + "\t" + "Skuadra: " + getEmriSkuadres() + "\t" + "Piket: " + ActualPoints
                + "\t" + "Nr. garave: " + nrGarave + "\t" + "Nr. No1: " + nrVendeTePara + "\t" + "Nr. No2: " + nrVendeTeDyta
                + "\t" + "Nr. No3: " +  nrVendeTeTreta + "\t" + "Vendndodhja: " + vendndodhja;
    }
}



