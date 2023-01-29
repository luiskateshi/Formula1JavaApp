package Gui;

import Main.Formula1Shofer;
import Main.Gara;
import Main.MenaxhimKampionatiFormula1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import class Main.Gara from src\Main.Gara.java


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameButton5 {
    private JButton confirmButton;

    public FrameButton5(ArrayList<Gara> races) {

        // kolonat e tabeles JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Vendodhja");
        model.addColumn("Emri i shoferit");
        model.addColumn("Emri i skuadres");
        model.addColumn("Pozicioni");

        //popullimi i modelit me te dhena nga ArrayList
        for (Gara race : races) {
            Object[] row = {race.getData(), race.getVendndodhja(), race.getEmriShoferit(), race.getEmriSkuadres(), race.getPozicioni()};
            model.addRow(row);
        }

        //vendosja e modelit ne JTable
        JTable table = new JTable(model);

        // create a JFrame and add the JTable to it
        JFrame frame = new JFrame("Tabela e garave te gjeneruara rastesisht");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        confirmButton = new JButton("Konfirmo");
        frame.add(confirmButton, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setVisible(true);

        //confirmButton
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //ketu do te shtojme garat e kujuara ne menyre te rastesishme ne arrayList races
                MenaxhimKampionatiFormula1.races.addAll(races);
                //ketu behet update cdo shofer qe mori pjese ne gare ne arrayList drivers
                int i=0;
                for(Formula1Shofer driver : MenaxhimKampionatiFormula1.drivers)
                {
                    Gara.updateDriversFromRace(i, MenaxhimKampionatiFormula1.drivers, races.get(i).getPozicioni());
                    i++;
                }
                //shfaq nje mesazh
                JOptionPane.showMessageDialog(null, "Main.Gara e krijuar u shtua ne memorje. Shtypni save per te ruajtur ndryshimet ne file.");
                //mbyll frame
                frame.dispose();

            }
        });
    }

}
