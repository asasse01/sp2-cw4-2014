/**
 * Created by abby on 22/12/14.
 */
 
 import java.util.Scanner;
public class BattleshipGame {

    public static void main(String[] args) {
        
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        
        Scanner in = new Scanner(System.in);
        int x;
        int y;
        
        System.out.println("Welcome to the Battleship Game.");
        System.out.println("Please enter your shots, giving coordinates x and y on a new line)");
        x = in.nextInt();
        y = in.nextInt();
        
        ocean.print();
        ocean.shootAt(x, y;)
        
        // TODO request user input & run game
    }
}
