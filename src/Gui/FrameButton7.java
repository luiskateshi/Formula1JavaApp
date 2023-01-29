package Gui;

import Main.Gara;

import java.awt.*;
import java.util.ArrayList;
//import class Main.Gara from src\Main.Gara.java


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrameButton7 {
    public FrameButton7(ArrayList<Gara> races) {


        String[] columnNames = {"Data","Vendodhja", "Emri shoferit", "Emri skuadres", "Pozicioni"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Gara row : races) {
            Object[] data = {row.getData(), row.getVendndodhja(), row.getEmriShoferit(), row.getEmriSkuadres(), row.getPozicioni()};
            model.addRow(data);
        }

        JTable table = new JTable(model);
        JFrame frame = new JFrame("ARenditja e garave sipas datave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setVisible(true);
    }

}

