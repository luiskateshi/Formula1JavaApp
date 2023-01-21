import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class Formula1Shofer extends Shofer {
    private int nrVendeTePara;
    private int nrVendeTeDyta;
    private int nrVendeTeTreta;
    private int ActualPoints;
    private int nrGarave;
    private String vendndodhja;
    private static ArrayList<Formula1Shofer> shoferi = new ArrayList<>();

    public Formula1Shofer(String emri, String mbiemri, String emriSkuadres, int nrVendeTePara, int nrVendeTeDyta, int nrVendeTeTreta, int actualPoints, int nrGarave, String vendndodhja) {
        super(emri, mbiemri, emriSkuadres);
        this.nrVendeTePara = nrVendeTePara;
        this.nrVendeTeDyta = nrVendeTeDyta;
        this.nrVendeTeTreta = nrVendeTeTreta;
        this.ActualPoints = actualPoints;
        this.nrGarave = nrGarave;
        this.vendndodhja = vendndodhja;
    }

    public static void fillArrayList(){
        shoferi.add(new Formula1Shofer("luis", "hamilton", "Mercedes", 5, 2, 4, 25, 3, "UK"));
        shoferi.add(new Formula1Shofer("seb", "vetel", "ferrari", 7, 2, 4, 30, 3, "Germany"));
        shoferi.add(new Formula1Shofer("valteri", "botas", "honda", 4, 2, 4, 25, 3, "Finland"));
    }

    public static void ShfaqStatistikaShoferi(String emriShoferi){
        for (Formula1Shofer z : shoferi){
            if (z.getEmri().equals(emriShoferi))
                System.out.println(z);
        }
    }

    public static void ShfaqStatistikaTeGjitheShoferet(){
        Collections.sort(shoferi, new Formula1ShoferComparator());
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

