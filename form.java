package cardgame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.awt.Dimension;






public class form {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel feld1;
    private JLabel feld5;
    private JLabel feld2;
    private JLabel feld4;
    private JLabel feld3;
    private JButton mischenButton;
    private JButton karteNehmenButton;
    private JRadioButton rotRadioButton;
    private JRadioButton schwarzRadioButton;
    private JRadioButton hoeherRadioButton;
    private JRadioButton niedrigerRadioButton;
    private JRadioButton zwischenRadioButton;
    private JRadioButton ausserhalbRadioButton;
    private JRadioButton herzRadioButton;
    private JRadioButton karoRadioButton;
    private JRadioButton pikRadioButton;
    private JRadioButton kreuzRadioButton;

    Card cardgame []= new Card[52];
    int pos = 0;
    static int zaehler=1;
    int antwort1= 0;
    int antwort2=0;
    int antwort3 =0;

    public form(){

        for(int i=0; i<52;i++){
           cardgame[i]= new Card(i);
        }

        mischenButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { karteMischen();}
        });

        karteNehmenButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { karteLegen();}
        });



    }




    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run(){displayFrame();}
        });
    }

    static void displayFrame(){
        JFrame jframe = new JFrame("Schlag den Mahler");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setPreferredSize((new Dimension(700,600)));
        jframe.setContentPane(new form().mainPanel);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setExtendedState(JFrame.MAXIMIZED_HORIZ);
        jframe.setResizable(false);
    }


    public void karteMischen(){
        Collections.shuffle(Arrays.asList(cardgame));
    }

    public void karteLegen(){

        ImageIcon card = cardgame[pos].pic;
        int nr = cardgame[pos].nr;
        pos++;

        switch(zaehler) {
            case 1 :
                feld2.setIcon(card);
            if (rotRadioButton.isSelected() && nr < 26||(schwarzRadioButton.isSelected() && nr > 25)) {
                JOptionPane.showMessageDialog(null, "richtig!");
                zaehler++;
                antwort1=nr;
            }

            else{
                JOptionPane.showMessageDialog(null, "Game Over!");
                feld2.setIcon(new ImageIcon(getClass().getResource("./res/pos1.png")));
                feld3.setIcon(new ImageIcon(getClass().getResource("./res/pos2.png")));
                feld4.setIcon(new ImageIcon(getClass().getResource("./res/pos3.png")));
                feld5.setIcon(new ImageIcon(getClass().getResource("./res/pos4.png")));
                antwort1= 0;
                antwort2=0;
                antwort3 =0;
                zaehler=1;
                rotRadioButton.setSelected(false);
                schwarzRadioButton.setSelected(false);
            }
            break;

            case 2 :

                feld3.setIcon(card);
            if(hoeherRadioButton.isSelected()&& nr%13>=antwort1%13||(niedrigerRadioButton.isSelected()&& nr%13<=antwort1%13)){
                JOptionPane.showMessageDialog(null, "richtig!");
                zaehler++;
                antwort2=nr;
            }

            else{
                JOptionPane.showMessageDialog(null, "Game Over!");
                feld2.setIcon(new ImageIcon(getClass().getResource("./res/pos1.png")));
                feld3.setIcon(new ImageIcon(getClass().getResource("./res/pos2.png")));
                feld4.setIcon(new ImageIcon(getClass().getResource("./res/pos3.png")));
                feld5.setIcon(new ImageIcon(getClass().getResource("./res/pos4.png")));
                antwort1= 0;
                antwort2=0;
                antwort3 =0;
                zaehler=1;
                hoeherRadioButton.setSelected(false);
                niedrigerRadioButton.setSelected(false);
            }
            break;

            case 3:
                feld4.setIcon(card);

                if((zwischenRadioButton.isSelected() && ( ( (nr%13)>=(antwort1%13) && (nr%13)<=(antwort2%13) ) || ( (nr%13)<=(antwort1%13) && (nr%13)>=(antwort2%13) ) ) ) || (ausserhalbRadioButton.isSelected() && ( ( (nr%13)<=(antwort1%13) && (nr%13)<=(antwort2%13) ) || ( (nr%13)>(antwort1%13) && (nr%13)>(antwort2%13) ) ) ) ){
                    JOptionPane.showMessageDialog(null, "richtig!");
                    zaehler++;
                    antwort3=nr;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Game Over!");
                    feld2.setIcon(new ImageIcon(getClass().getResource("./res/pos1.png")));
                    feld3.setIcon(new ImageIcon(getClass().getResource("./res/pos2.png")));
                    feld4.setIcon(new ImageIcon(getClass().getResource("./res/pos3.png")));
                    feld5.setIcon(new ImageIcon(getClass().getResource("./res/pos4.png")));
                    antwort1= 0;
                    antwort2=0;
                    antwort3 =0;
                    zaehler=1;
                    zwischenRadioButton.setSelected(false);
                    ausserhalbRadioButton.setSelected(false);

                }
                break;


            case 4:
                feld5.setIcon(card);

                if(herzRadioButton.isSelected()&& (nr<26 && nr>12)||(karoRadioButton.isSelected()&& (nr<13 && nr>0) )||(pikRadioButton.isSelected()&& (nr<39 && nr>25))||(kreuzRadioButton.isSelected()&& (nr<=51 && nr>38))){
                    JOptionPane.showMessageDialog(null, "Spiel gewonnen!");
                    zaehler++;
                }

                else{
                    JOptionPane.showMessageDialog(null, "Game Over!");
                    feld2.setIcon(new ImageIcon(getClass().getResource("./res/pos1.png")));
                    feld3.setIcon(new ImageIcon(getClass().getResource("./res/pos2.png")));
                    feld4.setIcon(new ImageIcon(getClass().getResource("./res/pos3.png")));
                    feld5.setIcon(new ImageIcon(getClass().getResource("./res/pos4.png")));
                    antwort1= 0;
                    antwort2=0;
                    antwort3 =0;
                    zaehler=1;
                    herzRadioButton.setSelected(false);                     // geht irgendwie nicht, nicht schön aber selten, ist mir jetzt aber egal
                    karoRadioButton.setSelected(false);
                    pikRadioButton.setSelected(false);
                    kreuzRadioButton.setSelected(false);

                }
                break;

        }

    }


}
