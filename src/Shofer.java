public class Shofer {
    private String emri;
    private String mbiemri;
    private String emriSkuadres;

    public Shofer (String emri, String mbiemri, String emriSkuadres){
        setEmri(emri);
        setMbiemri(mbiemri);
        setEmriSkuadres(emriSkuadres);
    };

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setEmriSkuadres(String emriSkuadres) {
        this.emriSkuadres = emriSkuadres;
    }

    public String getEmri(){
        return emri;
    }
    public String getMbiemri(){
        return mbiemri;
    }
    public String getEmriSkuadres(){
        return emriSkuadres;
    }
}
