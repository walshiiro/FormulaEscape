package Main;

import Entity.Player;
import Objects.SuperObjects;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int OriginalSize = 16;
    public  final int tileSize = OriginalSize *3;
    public int maxScreenCol = 30;
    public int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //WORLD SETTING
    public final int maxWorldCol = 87;
    public final int maxWorldRow =20 ;
    public int worldWigth = maxWorldCol * tileSize;
    public int worldHeight = maxWorldRow * tileSize;




    int fps=60;


    TileManager tilemanager = new TileManager(this);
    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,KeyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public UI Ui = new UI(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public SuperObjects objs[] = new SuperObjects[9];




    public void setupGame()
    {
        aSetter.setObject();
    }
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }


    /*
    @Override
    public void run() {
        double drawInter = 1000000000/fps;
        double nextDraw = System.nanoTime() + drawInter;
        while(gameThread != null)
        {
            update();
            repaint();

            try
            {
                double remainingTime = nextDraw - System.nanoTime();
                remainingTime/=100000;
                if(remainingTime <0)
                    remainingTime=0;
                Thread.sleep((long) remainingTime);
                nextDraw += drawInter;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

     */
    public void run()
    {
        double drawInter = 1000000000/fps;
        long lastTime = System.nanoTime();
        double delta = 0;
        long cunrrentTime=0;
        //long timer =0;
       // long drawCount=0;
        while(gameThread != null)

        {
            cunrrentTime = System.nanoTime();
            delta += (cunrrentTime - lastTime) / drawInter;
           // timer +=(cunrrentTime - lastTime);
            lastTime = cunrrentTime;
            if(delta>=1)
            {
                update();
                repaint();
                delta--;
               // drawCount++;

            }
           /* if(timer>=1000000000)
            {
                System.out.println("FPS"+drawCount);
                drawCount=0;
                timer=0;
            } */
        }


    }

    public void update()
    {
        player.update();


    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 =  (Graphics2D)g;
        //tile
        tilemanager.draw(g2);
        //object
        for(int i=0;i<objs.length; i++)
        {
            if(objs[i]!= null)
            {
                objs[i].draw(g2,this);
            }
        }
        //player
        player.draw(g2);
        //UI
        Ui.draw(g2);




    }
}
