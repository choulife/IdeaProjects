// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int min = 0;
        int max = 100;
        Random r = new Random();
        int secret = r.nextInt(max - min) + min;
        //System.out.println(secret);

        while (true){
            System.out.print("Make a guess (between " + min + " and " + max + "): ");
            int guess = s.nextInt();
            if (guess < min || guess > max){
                System.out.println("Please make a valid guess");
                continue;
            }
            if (guess == secret){
                System.out.println("You win! The secret is " + secret);
                break;
            }
            if (guess < secret){
                min = guess;
            }
            if (guess > secret){
                max = guess;
            }
        }
    }
}