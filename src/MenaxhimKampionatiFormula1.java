import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;


public class MenaxhimKampionatiFormula1 implements MenaxhimKampionati {
    int nrShofereve;
    int nrSkuadrave;
    private static Scanner sc = new Scanner(System.in);
    ArrayList<Gara> races = new ArrayList<>();
    ArrayList<Formula1Shofer> drivers = new ArrayList<>();
    public static void main(String[] args) {

        MenaxhimKampionatiFormula1 m = new MenaxhimKampionatiFormula1();
        m.LoadData();
        m.LoadDataShofer();

        while (true) {
            ShfaqMenune();
            char komanda = sc.next().charAt(0);
            m.doMenu(komanda);
        }


    }

    static void ShfaqMenune(){

        System.out.println("Zgjidhni nje nga funksionalitetet e meposhtme nepermjet karaktereve ne te majte:");
        System.out.println("1-    Shto nje shofer te ri");
        System.out.println("2-    Perditeso shoferin per nje skuader ekzistuese");
        System.out.println("3-    Fshi shoferin dhe skuadren e tij");
        System.out.println("4-    Shfaq Statistikat per nje shofer");
        System.out.println("5-    Shfaq Statistikat per shoferet (Actual points DESC)");
        System.out.println("6-    Shto nje gare te re");
        System.out.println("7-    Shfaq Statistikat per shoferet (Actual points ASC)");
        System.out.println("8-    Shfaq Statistikat per shoferet (Nr of wins DESC)");
        System.out.println("s-    Save data");
        System.out.println("x-    Exit");
//        System.out.println("\nFunksionalitetet me nderfaqe grafike (GUI):");
//        System.out.println("7-    Shfaq ");
    }
    void doMenu(char komanda){

        switch (komanda) {
            case '1':
                Formula1Shofer.addDriverToArrayList(drivers);
                break;
            case '2':
                Shofer.rename(drivers);
                break;
            case '3':
                Shofer.remove(drivers);
                break;
            case '4':
                Formula1Shofer.ShfaqStatistikaShoferi(drivers);
                break;
            case '5':
                Formula1Shofer.ShfaqStatistikaTeGjitheShoferetActualPointsDSC(drivers);
                break;
            case '6':
                Gara.addRace(races, drivers);
                break;
            case '7':
                Formula1Shofer.ShfaqStatistikaTeGjitheShoferetActualPointsASC(drivers);
                break;
            case '8':
            Formula1Shofer.ShfaqStatistikaTeGjitheShoferetNrVendeTeParaDESC(drivers);
            break;
            case 's':
                SaveData();
                SaveDataShofer();
                break;
            case 'x':
                System.out.println("Ju keni perfunduar punen me programin!");
                System.exit(0);
                break;
            default:
                System.out.println("Funksioni i kerkuar nuk ekziston, provoni perseri!");
        }
    }


    public void LoadData(){

        //Leximi i File-it "garat.txt" dhe vendosja e informacionit ne objekt-vektorin ArrayList<Gara> races
        try {
            FileReader fr = new FileReader(file2);
            BufferedReader input = new BufferedReader(fr);
            String line;
            while((line = input.readLine()) != null)
            {
                String[] info = null;
                info = line.split("\\t");
                races.add(new Gara(info[0].toString(), info[1].toString(), info[2].toString(), parseInt(info[3])));
            }
            input.close();
            fr.close();
        }
        catch (IOException e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u lexuan me sukses nga file.");

    }
    public void SaveData(){

        //Vendosja e cdo informacioni te futur nga user-i deri ne kete moment nga objekt-vektori ArrayList<Gara> races ne file-in "garat.txt"
        try {
            FileWriter fw = new FileWriter(file2);
            Writer output = new BufferedWriter(fw);

            for(Gara race : races)
            {
                output.write(race.getData().toString()+ "\t" +race.getEmriShoferit().toString() + "\t" + race.getEmriSkuadres().toString() + "\t" + race.getPozicioni() +"\n");
            }
            output.close();
            fw.close();
        }
        catch (Exception e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u ruajten me sukses ne file.");
    }

    public void LoadDataShofer(){

        //Leximi i File-it "garat.txt" dhe vendosja e informacionit ne objekt-vektorin ArrayList<Gara> races
        try {
            FileReader fr1 = new FileReader(file1);
            BufferedReader input = new BufferedReader(fr1);
            String line;
            while((line = input.readLine()) != null)
            {
                String[] info = null;
                info = line.split("\\t");
                drivers.add(new Formula1Shofer(info[0].toString(), info[1].toString(), info[2].toString(),parseInt(info[3]),parseInt(info[4]),parseInt(info[5]),parseInt(info[6]),parseInt(info[7]),info[8].toString()));
            }
            input.close();
            fr1.close();
        }
        catch (IOException e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u lexuan me sukses nga file.");

    }
    public void SaveDataShofer(){

        //Vendosja e cdo informacioni te futur nga user-i deri ne kete moment nga objekt-vektori ArrayList<Gara> races ne file-in "garat.txt"
        try {

            FileWriter fw1 = new FileWriter(file1);
            Writer output = new BufferedWriter(fw1);

            for(Formula1Shofer drivers : drivers)
            {
                output.write(drivers.getEmri().toString()+ "\t" +drivers.getMbiemri().toString() + "\t" + drivers.getEmriSkuadres().toString() + "\t" + drivers.getNrVendeTePara() +"\t"+ drivers.getNrVendeTeDyta() +"\t"+ drivers.getNrVendeTeTreta() +"\t"+ drivers.getActualPoints() +"\t"+ drivers.getNrGarave() +"\t"+ drivers.getVendndodhja().toString() +"\n");
            }
            output.close();
            fw1.close();
        }
        catch (Exception e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u ruajten me sukses ne file.");
    }

}
