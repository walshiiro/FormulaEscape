package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Go out");
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/icon/icon.jpg")));
        GamePanel GamePanel = new GamePanel();



        window.add(GamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GamePanel.setupGame();
        GamePanel.startGameThread();


    }
}
