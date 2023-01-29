package Gui;

import Main.Formula1Shofer;
import Main.Gara;
import Main.MenaxhimKampionatiFormula1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    public MyFrame(ArrayList<Gara> races, ArrayList<Formula1Shofer> drivers) {
        setLayout(new GridLayout(3, 3));
        button1 = new JButton("Gjenero gare rastesore");
        add(button1);
        button2 = new JButton("Shfaq Shoferet (DESC sipas pikeve)");
        add(button2);
        button3 = new JButton("Shfaq Shoferet (ASC sipas pikeve)");
        add(button3);
        button4 = new JButton("Shfaq Shoferet (DESC sipas fitoreve)");
        add(button4);
        button5 = new JButton("Gjenero gare me probabilitet");
        add(button5);
        button6 = new JButton("Button 6");
        add(button6);
        button7 = new JButton("Button 7");
        add(button7);
        button8 = new JButton("SAVE");
        add(button8);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameButton1 var = new FrameButton1(Gara.generateRandomRace(races, drivers));
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formula1Shofer.SortShoferetByActualPointsDESC(drivers);
                FrameButton2 var = new FrameButton2(drivers);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formula1Shofer.SortShoferetByActualPointsASC(drivers);
                FrameButton3 var = new FrameButton3(drivers);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formula1Shofer.SortShoferetByNrVendeTeParaDESC(drivers);
                FrameButton4 var = new FrameButton4(drivers);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameButton5 var = new FrameButton5(Gara.generateRandomRaceProbability(races, drivers));
            }
        });
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameButton6 ren = new FrameButton6(Gara.Renditje(races));
            }
        });
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String z = JOptionPane.showInputDialog("Vendos Emrin e Garuesit");
                FrameButton7 shf = new FrameButton7(Gara.shfaqGarat(races,z));
            }
        });
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenaxhimKampionatiFormula1.SaveData();
                MenaxhimKampionatiFormula1.SaveDataShofer();
                //shfaq nje mesazh qe te dhenat u ruajten
                JOptionPane.showMessageDialog(null, "Te dhenat u ruajten ne file.");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setVisible(true);
    }

}