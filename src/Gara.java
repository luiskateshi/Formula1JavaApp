import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.in;

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

    static int FindPointsFromPosition(int pozicioni)
    {
        switch (pozicioni) {
            case 1:
                return 25;
            case 2:
                return 18;
            case 3:
                return 15;
            case 4:
                return 12;
            case 5:
                return 10;
            case 6:
                return 8;
            case 7:
                return 6;
            case 8:
                return 4;
            case 9:
                return 2;
            case 10:
                return 1;
            default:
                return 0;
        }

    }
    public static void addRace(ArrayList<Gara> races, ArrayList<Formula1Shofer> drivers){

        String data;
        int id;
        int pozicioni = 0;

        Scanner a = new Scanner(in);

        System.out.println("##### Shtimi i nje gare te re #####\n");

        System.out.println("Data ne formatin dd/mm/yyyy: ");
        data = a.next();

        System.out.println("Nr. i pjesmarresve ne gare: ");
        int nr = a.nextInt();

        for(int i = 0; i < nr; i++){
            System.out.println("Shkruani te dhenat per pjesmarresin nr.  "+i+": ");
            System.out.println("Zgjidhni shoferin duke dhene numrin perkates: ");

            int count = 0;
            for (Formula1Shofer x : drivers) {
                System.out.println(count + " - " + x.getEmri().toString());
                count++;
            }


            id = a.nextInt();
            String emriShoferit = drivers.get(id).getEmri();
            String emriSkuadres = drivers.get(id).getEmriSkuadres();

            System.out.println("Shkruani pozicionin per shoferin # "+emriShoferit+" # dhe skuadren # "+emriSkuadres+" #:");
            pozicioni = a.nextInt();

            updateDriversFromRace(id, drivers, pozicioni);
            races.add(new Gara(data, emriShoferit, emriSkuadres, pozicioni));


        }


    }

    //Kjo eshte nje metode qe mund te perdoret per te renditur garat sipas datave

   public static void Renditje(ArrayList<Gara> gara) {
       Collections.sort(gara, new RenditjaGaraCompare());
       for (Gara a : gara)
            System.out.println(a);


    }

    public static void shfaqGarat(ArrayList<Gara> gara) {
        Scanner in=new Scanner(System.in);
        System.out.println("Vendos emrin e shoferit");
        String emri = in.next();
        for (Gara a : gara) {
            if (a.getEmriShoferit().equalsIgnoreCase(emri)) {
                System.out.println(a);
            }
        }
    }
   @Override
    public String toString(){
        return "Data: " + getData() + "\tEmri: " + getEmriShoferit() + "\tSkuadra: " +
                getEmriSkuadres() + "\tPozicioni: " + getPozicioni();
    }




    public static void updateDriversFromRace(int idShoferi, ArrayList<Formula1Shofer> drivers, int pozicioni){

        Formula1Shofer a = drivers.get(idShoferi);

        //fushat qe mund te ndryshojne ne kete pike jane: int nrVendeTePara, nrVendeTeDyta, nrVendeTeTreta, ActualPoints, nrGarave                                                                            nrGarave;

        int Vend1 = 0;
        int Vend2 = 0;
        int Vend3 = 0;

        switch (pozicioni){
            case 1:
                Vend1++;
                break;
            case 2:
                Vend2++;
                break;
            case 3:
                Vend3++;
                break;
            default: break;
        }

        int piket = FindPointsFromPosition(pozicioni);

        Formula1Shofer driver = new Formula1Shofer(
                a.getEmri(),
                a.getMbiemri(),
                a.getEmriSkuadres(),
                a.getNrVendeTePara() + Vend1,
                a.getNrVendeTeDyta() + Vend2,
                a.getNrVendeTeTreta() + Vend3,
                piket,
                a.getNrGarave() + 1,
                a.getVendndodhja()
        );

        drivers.set(idShoferi, driver);
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
