public class MenaxhimKampionatiFormula1 implements MenaxhimKampionati {
    int nrShofereve;
    int nrSkuadrave;
    void ShfaqMenune(){
        System.out.println("++++++++++++++++++++++ Formula1 App Menu ++++++++++++++++++++++");
        System.out.println("Zgjidhni nje nga opsionet e meposhtme duke dhene nr. perkates:");
        System.out.println("1-    Shto nje shofer te ri");
        System.out.println("2-    Perditeso shoferin per nje skuader ekzistuese");
        System.out.println("2-    Fshi shoferin dhe skuadren e tij");
    }
    public static void main(String[] args) {
        MenaxhimKampionatiFormula1 main = new MenaxhimKampionatiFormula1();
        main.ShfaqMenune();
    }

}
