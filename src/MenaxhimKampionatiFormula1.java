import java.io.*;
import java.util.*;


public class MenaxhimKampionatiFormula1 implements MenaxhimKampionati {
    int nrShofereve;
    int nrSkuadrave;
    private static Scanner sc = new Scanner(System.in);
    ArrayList<Gara> races = new ArrayList<>();
    public static void main(String[] args) {

        //ShfaqMenune();
        MenaxhimKampionatiFormula1 m = new MenaxhimKampionatiFormula1();
        //m.ReadFile();
        m.addToFile();


        //Read object from file


    }
    static void ShfaqMenune(){
        System.out.println("++++++++++++++++++++++ Formula1 App Menu ++++++++++++++++++++++");
        System.out.println("Zgjidhni nje nga opsionet e meposhtme duke dhene nr. perkates:");
        System.out.println("1-    Shto nje shofer te ri");
        System.out.println("2-    Perditeso shoferin per nje skuader ekzistuese");
        System.out.println("3-    Fshi shoferin dhe skuadren e tij");
        System.out.println("4-    Listo te gjithe shoferat");
    }
    public void ReadFile(){
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(file2);
            ObjectInputStream in = new ObjectInputStream(file);

            Gara g1 = null;
            // Method for deserialization of object
            g1 = (Gara)in.readObject();
            races.add(g1);

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + g1.getData());
            System.out.println("b = " + g1.getEmriShoferit());
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        System.out.println("Infos u lexuan me sukses nga file.");
    }

    public void addToFile(){
        //Gara g = new Gara("05/01/2023", "Hans Hamilton", "Mercedes Benz", 3);
        //races.add(g);

        //per te shtuar garat nga memorja ne file
        try{
            new FileOutputStream("garat.txt", true).close();
            FileOutputStream fos = new FileOutputStream("garat.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Gara race : races) {
                oos.writeObject(race);
            }
            fos.close();
        }
        catch (IOException i){
            i.printStackTrace();
        }

        //per te shtuar shoferat nga memorja ne file
        try{
            new FileOutputStream("garat.txt", true).close();
            FileOutputStream fos = new FileOutputStream("garat.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Gara race : races) {
                oos.writeObject(race);
            }
            fos.close();
        }
        catch (IOException i){
            i.printStackTrace();
        }

        System.out.println("Ruajtja e informacionit ne file perfudnoi me sukses.");
    }

}
