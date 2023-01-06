import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;


public class MenaxhimKampionatiFormula1 implements MenaxhimKampionati {
    int nrShofereve;
    int nrSkuadrave;
    private static Scanner sc = new Scanner(System.in);
    //ArrayList<Gara> races = new ArrayList<>();
    public static void main(String[] args) {

        ShfaqMenune();
        MenaxhimKampionatiFormula1 m = new MenaxhimKampionatiFormula1();

        ArrayList<Gara> races = new ArrayList<>();
        m.LoadData(races);

        m.SaveData(races);

        //Read object from file


    }
    static void ShfaqMenune(){
        System.out.println("++++++++++++++++++++++ Formula1 App Menu ++++++++++++++++++++++");
        System.out.println("Zgjidhni nje nga opsionet e meposhtme duke dhene nr. perkates:");
        System.out.println("1-    Shto nje shofer te ri");
        System.out.println("2-    Perditeso shoferin per nje skuader ekzistuese");
        System.out.println("3-    Fshi shoferin dhe skuadren e tij");
        System.out.println("4-    Listo te gjithe shoferat");
        System.out.println("4-    Save data");
        System.out.println("4-    Exit");

    }

    public void LoadData(ArrayList<Gara> races){
        try {
            FileReader fr = new FileReader(file2);
            BufferedReader input = new BufferedReader(fr);
            String line;
            while((line = input.readLine()) != null)
            {
                String[] info = null;
                info = line.split("\\t");
                Gara.addRace(races, info[0].toString(), info[1].toString(), info[2].toString(), parseInt(info[3]));
            }
            input.close();
        }
        catch (IOException e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u lexuan me sukses nga file.");
    }
    public void SaveData(ArrayList<Gara> races){
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
