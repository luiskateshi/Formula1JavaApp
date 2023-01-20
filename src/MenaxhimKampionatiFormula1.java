import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        ShfaqMenune();


        m.SaveData();

        int nrShofereve;
        int nrSkuadrave;

        Scanner sc = new Scanner(System.in);
        ArrayList<Gara> races = new ArrayList<>();
//        Test per klasen Formula1Shofer
            Formula1Shofer.fillArrayList();
            Formula1Shofer.ShfaqStatistikaTeGjitheShoferet();

        }

    static void ShfaqMenune(){

        System.out.println("Zgjidhni nje nga funksionalitetet e meposhtme nepermjet karaktereve ne te majte:");
        System.out.println("1-    Shto nje shofer te ri");
        System.out.println("2-    Perditeso shoferin per nje skuader ekzistuese");
        System.out.println("3-    Fshi shoferin dhe skuadren e tij");
        System.out.println("4-    Shfaq Statistikat per nje shofer");
        System.out.println("5-    Shfaq Statistikat per shoferet (Actual points DESC)");
        System.out.println("6-    Shto nje gare te re");
        System.out.println("s-    Save data");
        System.out.println("x-    Exit");
        System.out.println("\nFunksionalitetet me nderfaqe grafike (GUI):");
        System.out.println("7-    Shfaq ");
    }
    void doMenu(char komanda){
        switch (komanda) {
            case '1':
                //therritja e funksionit perkates
                break;
            case '6':
                Gara.addRace(races, drivers);
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
        }
        catch (Exception e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u ruajten me sukses ne file.");
    }

}
