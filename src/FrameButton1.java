import java.awt.Dimension;
import java.util.ArrayList;
//import class Gara from src\Gara.java


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrameButton1 {
    public FrameButton1(ArrayList<Gara> races) {
        // create an ArrayList of User objects


        // create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Vendodhja");
        model.addColumn("Emri i shoferit");
        model.addColumn("Emri i skuadres");
        model.addColumn("Pozicioni");

        // populate the model with data from the ArrayList
        for (Gara race : races) {
            Object[] row = {race.getData(), race.getVendndodhja(), race.getEmriShoferit(), race.getEmriSkuadres(), race.getPozicioni()};
            model.addRow(row);
        }

        // create a JTable and set its model
        JTable table = new JTable(model);

        // create a JFrame and add the JTable to it
        JFrame frame = new JFrame("Tabela e garave te gjeneruara rastesisht");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setVisible(true);
    }

}
