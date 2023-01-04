import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class MenaxhimKampionatiFormula1 implements MenaxhimKampionati {
    int nrShofereve;
    int nrSkuadrave;
    private static Scanner sc = new Scanner(System.in);
    ArrayList<Gara> races = new ArrayList<>();
    public static void main(String[] args) {

        ShfaqMenune();

    }
    static void ShfaqMenune(){
        System.out.println("++++++++++++++++++++++ Formula1 App Menu ++++++++++++++++++++++");
        System.out.println("Zgjidhni nje nga opsionet e meposhtme duke dhene nr. perkates:");
        System.out.println("1-    Shto nje shofer te ri");
        System.out.println("2-    Perditeso shoferin per nje skuader ekzistuese");
        System.out.println("2-    Fshi shoferin dhe skuadren e tij");
    }
    void addToFile() throws Exception{
        Gara g = new Gara("04/01/2023", "Luis Hamilton", "Mercedes Benz", 3);
        races.add(g);

        new FileOutputStream("myCars.txt", true).close();
        FileOutputStream fos = new FileOutputStream("myCars.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Gara race : races) {
            oos.writeObject(race);
        }
        fos.close();
    }

}
