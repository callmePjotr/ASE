package cardgame;
import javax.swing.*;

public class Card {
    int nr;
    ImageIcon pic;
    Card(int n){
        nr = n;
        java.net.URL url = getClass().getResource("./res/card"+nr+".png");
        pic = new ImageIcon(url, "karte"+nr);
    }

}
