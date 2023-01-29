import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FrameButton3 {
    public FrameButton3(ArrayList<Formula1Shofer> drivers) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Emri");
        model.addColumn("Mbiemri");
        model.addColumn("Emri i skuadres");
        model.addColumn("Piket");
        model.addColumn("Nr i garave");
        model.addColumn("Nr TOP1");
        model.addColumn("Nr TOP2");
        model.addColumn("Nr TOP3");
        model.addColumn("Vendndodhja");

        for (Formula1Shofer driver : drivers) {
            Object[] row = {driver.getEmri(), driver.getMbiemri(), driver.getEmriSkuadres(), driver.getActualPoints(), driver.getNrGarave(), driver.getNrVendeTePara(), driver.getNrVendeTeDyta(), driver.getNrVendeTeTreta(), driver.getVendndodhja()};
            model.addRow(row);
        }

        // create a JTable and set its model
        JTable table = new JTable(model);

        // create a JFrame and add the JTable to it
        JFrame frame = new JFrame("Tabela e shofereve te renditur sipas pikeve (ne rend rrites) ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setPreferredSize(new Dimension(800, 200));
        frame.pack();
        frame.setVisible(true);
    }
}
