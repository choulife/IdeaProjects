import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    /*
    @Override
    public void paintComponent(Graphics g){
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.BLUE);
        g.fillRect(0,0,width,height);

        g.drawString("Hello World",100,100);
        g.setColor(Color.RED);
        g.drawLine(10,10,50,50);
        g.setColor(Color.BLACK);
        g.drawRect(120,120,50,60);
    }
    */

    /*
    @Override
    public void paintComponent(Graphics g){
        ImageIcon img = new ImageIcon("sunder.jpg");
        img.paintIcon(null,g,0,0);
    }
    */

    Sheep s;

    public Main(){
        s = new Sheep(40, 40);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        s.drawSheep(g);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 650);
        window.setContentPane(new Main());
        window.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        switch (k){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                 s.walk(0, -5);
                 break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                 s.walk(0, 5);
                 break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                 s.walk(5, 0);
                 break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                 s.walk(-5, 0);
                 break;
            default:
                JOptionPane.showMessageDialog(this,"Please use arrow key to move sheep");
        }
        repaint();
        /*
        if (k == KeyEvent.VK_UP){
            s.walk(0, -5);
        }
        if (k == KeyEvent.VK_DOWN){
            s.walk(0, 5);
        }
        if (k == KeyEvent.VK_RIGHT){
            s.walk(5, 0);
        }
        if (k == KeyEvent.VK_LEFT){
            s.walk(-5, 0);
        }
        //System.out.println(k);
        //System.out.println(s);
        repaint();
        */
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}