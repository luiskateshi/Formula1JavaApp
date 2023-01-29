import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFrame extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    public MyFrame(ArrayList<Gara> races, ArrayList<Formula1Shofer> drivers) {
        setLayout(new GridLayout(3, 3));
        button1 = new JButton("Button 1");
        add(button1);
        button2 = new JButton("Button 2");
        add(button2);
        button3 = new JButton("Button 3");
        add(button3);
        button4 = new JButton("Button 4");
        add(button4);
        button5 = new JButton("Button 5");
        add(button5);
        button6 = new JButton("Button 6");
        add(button6);
        button7 = new JButton("Button 7");
        add(button7);
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

}