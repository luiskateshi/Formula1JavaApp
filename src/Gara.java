import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.in;

public class Gara implements Serializable {
    String data;

    String vendndodhja;
    String emriShoferit;
    String emriSkuadres;
    int pozicioni;

    Gara() {}; //konstruktori default
    Gara(String data, String vendndodhja, String emriShoferit, String emriSkuadres, int pozicioni){
        this.vendndodhja = vendndodhja;
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
        String vendndodhja;
        int id;
        int pozicioni = 0;

        Scanner a = new Scanner(in);

        System.out.println("##### Shtimi i nje gare te re #####\n");

        System.out.println("Data ne formatin dd/mm/yyyy: ");
        data = a.next();
        System.out.println("Vendndodhja: ");
        vendndodhja = a.next();

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
            races.add(new Gara(data, vendndodhja, emriShoferit, emriSkuadres, pozicioni));


        }


    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    public static ArrayList<Gara> generateRandomRace(ArrayList<Gara> races, ArrayList<Formula1Shofer> drivers) {
        ArrayList<Gara> tempGara = new ArrayList<Gara>();
        int nrPjesmarresve = drivers.size();
        int nrGarave = races.size();

        String data = generateRadnomDate();

        String Vendodhja = generateRandomCity();

        int positions[] = generateRandomPositions(nrPjesmarresve);
        int i = 0;
        for (Formula1Shofer x : drivers) {
            tempGara.add(new Gara(data.toString(), Vendodhja, x.getEmri(), x.getEmriSkuadres(), positions[i]));
            i++;
        }
        return tempGara;
    }
    public static int[] generateRandomPositions(int nrPjesmarresve) {
        int positions[] = new int[nrPjesmarresve];
        for (int i = 0; i < nrPjesmarresve; i++) {
            while(true)
            {
                int position = createRandomIntBetween(1, nrPjesmarresve);
                if(checkIfPositionExists(positions, position))
                    continue;
                else
                {
                    positions[i] = position;
                    break;
                }
            }
        }
        return positions;
    }

    public static String generateRandomCity()
    {
        String qyteti[] = {"Tirana", "Durrësi", "Shkodra", "Elbasani", "Vlora", "Korça", "Fieri", "Berati", "Pogradeci"};
        Random rand = new Random();
        String Vendodhja = qyteti[rand.nextInt(qyteti.length)];
        return Vendodhja;
    }
    public static String generateRadnomDate()
    {
        Random rand = new Random();
        int dita = rand.nextInt(30) + 1;
        int muaji = rand.nextInt(12) + 1;
        int viti = rand.nextInt(20) + 2000;
        String data = dita + "/" + muaji + "/" + viti;
        return data;
    }


    public static ArrayList<Gara> generateRandomRaceProbability (ArrayList<Gara> races, ArrayList<Formula1Shofer> drivers)
    {
        ArrayList<Gara> tempGara = new ArrayList<Gara>();
        int nrPjesmarresve = drivers.size();
        int nrGarave = races.size();
        String data = generateRadnomDate();
        String Vendodhja = generateRandomCity();
        int StartPositions[] = generateRandomPositions(nrPjesmarresve);
        System.out.println("StartPositions: " + Arrays.toString(StartPositions));
        int FinishPositions[] = generateFinishPositionsWithProbability(fillProbabilityArray(), nrPjesmarresve);

        int i = 0;
        for (Formula1Shofer x : drivers) {
            tempGara.add(new Gara(data.toString(), Vendodhja, x.getEmri(), x.getEmriSkuadres(), FinishPositions[StartPositions[i]-1]));
            i++;
        }

        return tempGara;
    }
    public static int[] fillProbabilityArray()
    {
        int probability[] = new int[100];
        int nr = 5;
        for(int i = 0; i < 100; i++)
        {
            if(i >= 0 && i <= 39)
            {
                probability[i] = 1;
            }
            else if(i >= 40 && i <= 69)
            {
                probability[i] = 2;
            }
            else if(i >= 70 && i <= 79)
            {
                probability[i] = 3;
            }
            else if(i >= 80 && i <= 89)
            {
                probability[i] = 4;
            }
            else
            {
                probability[i] = nr;
                if(i%2!=0)
                nr++;
            }
        }
        return probability;
    }
    public static int[] generateFinishPositionsWithProbability(int[] probability, int nrPjesmarresve)
    {
        int positions[] = new int[nrPjesmarresve];

        try {
            for(int i = 0; i < nrPjesmarresve; i++)
            {
                if(i<=8)
                {
                    while(true)
                    {
                        int pos = probability[createRandomIntBetween(0, 99)];    //nga tabela pozicioneve te shperndara me probabilitet marrim nje pozicion random
                        if(checkIfPositionExists(positions, pos))
                        {
                            continue;
                        }
                        else
                        {
                            positions[i] = pos;
                            break;
                        }
                    }
                }
                else if(i>8)
                {
                    positions[i] = createRandomIntBetween(10, nrPjesmarresve);
                    while(true)
                    {
                        int position = createRandomIntBetween(10, nrPjesmarresve);
                        if(checkIfPositionExists(positions, position))
                            continue;
                        else
                        {
                            positions[i] = position;
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return positions;
    }

    public static boolean checkIfPositionExists(int[] positions, int position)
    {
        for(int i = 0; i < positions.length; i++)
        {
            if(positions[i] == position)
            {
                return true;
            }
        }
        return false;
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

    public String getVendndodhja() {
        return vendndodhja;
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
        return "Data: " + getData() + "\tVendndodhja: "+ getVendndodhja() + "\tEmri: " + getEmriShoferit() + "\tSkuadra: " +
                getEmriSkuadres() + "\tPozicioni: " + getPozicioni();
    }
}
