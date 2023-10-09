import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends JPanel {

    String type;
    int n;

    public Main(){
        type = JOptionPane.showInputDialog("Do you want an addition table or multiply table?(A or M)");
        n = Integer.parseInt(JOptionPane.showInputDialog("How big do you want the table to be ?"));
    }


    @Override
    public void paintComponent(Graphics g){
        int w = getWidth();
        int h = getHeight();
        int x = 0;
        int y = 0;
        int cellWidth = w / n;
        int cellHeight = h / n;

        //nested for loop
        for (int j = 1; j <= n ; j++){
            for (int i = 1; i <= n ; i++){
                if (i == 1 || j == 1){
                    g.setColor(Color.YELLOW);
                    g.fillRect(x, y, cellWidth,cellHeight);
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellWidth, cellHeight);

                if (i == 1){
                    g.drawString("" + j,x+10,y+20);
                } else if (j == 1){
                    g.drawString("" + i,x+10,y+20);
                } else {
                    int value;
                    if (type.toLowerCase().equals("a")){
                        value = i + j;
                    } else {
                        value = i * j;
                    }
                    g.drawString("" + value,x+10,y+20);
                }
                x += cellWidth;
            }
            x =0;
            y += cellHeight;
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setContentPane(new Main());
        window.setVisible(true);

    }
}