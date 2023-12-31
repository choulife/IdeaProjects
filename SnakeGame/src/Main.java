import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JPanel implements KeyListener {

    public static final int CELL_SIZE = 20;
    public static int width = 400;
    public static int height = 400;
    public static int row = height / CELL_SIZE;
    public static int column = width / CELL_SIZE;
    private Snake snake;
    private Fruit fruit;
    private Timer t;
    private int speed = 100;
    private static String direction;
    private boolean allowKeypress;

    public Main(){
        snake = new Snake();
        fruit = new Fruit();
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                repaint();
            }
        }, 0,speed);
        direction = "Right";
        addKeyListener(this);
        allowKeypress = true;
    }
    @Override
    public void paintComponent(Graphics g){
        // test timer
        // System.out.println("We are calling component...");
        // draw a black background
        g.fillRect(0, 0, width, height);
        snake.drawSnake(g);
        fruit.drawFruit(g);

        // remove snake tail and out it in head
        int snakeX = snake.getSnakeBody().get(0).x;
        int snakeY = snake.getSnakeBody().get(0).y;
        // right x += cell_size
        // down y += cell_size up y-+ cell_size
        if (direction.equals("Left")){
            snakeX -= CELL_SIZE;
        } else if (direction.equals("Up")){
            snakeY -= CELL_SIZE;
        } else if (direction.equals("Right")){
            snakeX += CELL_SIZE;
        } else if (direction.equals("Down")){
            snakeY += CELL_SIZE;
        }

        Node newHead  = new Node(snakeX, snakeY);
        snake.getSnakeBody().remove(snake.getSnakeBody().size() - 1);
        snake.getSnakeBody().add(0,newHead);
        allowKeypress = true;
        requestFocusInWindow();

    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(width,height);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Snake Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if (allowKeypress){
            if (e.getKeyCode() == 37 && !direction.equals("Right")){
                direction = "Left";
            } else if (e.getKeyCode() == 38 && !direction.equals("Down")){
                direction = "Up";
            } else if (e.getKeyCode() == 39 && !direction.equals("Left")){
                direction = "Right";
            } else if (e.getKeyCode() == 40 && !direction.equals("Up")){
                direction = "Down";
            }
            allowKeypress = false;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}