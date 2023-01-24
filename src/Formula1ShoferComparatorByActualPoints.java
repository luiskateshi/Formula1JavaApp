import java.util.Comparator;

public class Formula1ShoferComparatorByActualPoints implements Comparator<Formula1Shofer> {
    @Override
    public int compare(Formula1Shofer o1, Formula1Shofer o2) {
        if (o1.getActualPoints() > o2.getActualPoints())
            return -1;
        else if (o1.getActualPoints() == o2.getActualPoints()){
            if (o1.getNrVendeTePara() > o2.getNrVendeTePara())
                return -1;
            else if (o1.getNrVendeTePara() == o2.getNrVendeTePara())
                return 0;
            else
                return 1;
        }
        else
            return 1;
    }
}
