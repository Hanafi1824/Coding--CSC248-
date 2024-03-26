import javax.swing.*;
import java.awt.*;

class App2 extends JFrame{

    App2 (String title){
        super (title); //Pass the title to the frame layer 
        Container pane = getContentPane();

        JButton b = new JButton("Yes");
        pane.add(b, BorderLayout.WEST);

        b=new JButton("No");
        pane.add (b, BorderLayout.EAST);

        b=new JButton("Maybe");
        pane.add (b, BorderLayout.CENTER);

        setSize (500, 400);
        setVisible(true);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        App2 f = new App2 ("Testing Windows");
    }
}