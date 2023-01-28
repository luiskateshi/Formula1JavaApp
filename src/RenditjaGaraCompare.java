import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class RenditjaGaraCompare implements Comparator<Gara> {
    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public int compare(Gara o1, Gara o2) {
        try {
            return f.parse(o1.getData()).compareTo(f.parse(o2.getData()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }


}

