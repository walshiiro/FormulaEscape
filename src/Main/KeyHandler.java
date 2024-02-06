package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean goUp,goDown,goLeft,goRight;

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code==KeyEvent.VK_UP)
        {
            goUp=true;
        }
        if(code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN)
        {
            goDown=true;
        }
        if(code == KeyEvent.VK_A || code==KeyEvent.VK_LEFT)
        {
            goLeft=true;
        }
        if(code == KeyEvent.VK_D || code==KeyEvent.VK_RIGHT)
        {
            goRight=true;
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code==KeyEvent.VK_UP)
        {
            goUp=false;
        }
        if(code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN)
        {
            goDown=false;
        }
        if(code == KeyEvent.VK_A || code==KeyEvent.VK_LEFT)
        {
            goLeft=false;
        }
        if(code == KeyEvent.VK_D || code==KeyEvent.VK_RIGHT)
        {
            goRight=false;
        }


    }
}
