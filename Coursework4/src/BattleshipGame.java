/**
 * Created by abby on 22/12/14.
 */
 
 import java.util.Scanner;
public class BattleshipGame {

    public static void main(String[] args) {
        
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        
        boolean shot = false;
        
        Scanner in = new Scanner(System.in);
        int x;
        int y;
        String replayGame;
        boolean validResponse = true;

        
        System.out.println("Welcome to the Battleship Game.");
        
        do {
            System.out.println("Please enter your shots, giving coordinates x and y on a new line");
            x = in.nextInt();
            y = in.nextInt();
            
            ocean.print();
            shot = ocean.shootAt(x, y);
            if(shot){
                if(ocean.ships[x][y].isSunk()){// TODO create Ocean method
                    System.out.println("You just sunk a "+ocean.ships[x][y].getShipType());
                } else System.out.println("Hit");
            } else System.out.println("Miss");
            ocean.print();

        } while !(isGameOver());
        
        System.out.println("Game completed. Final Scores:");
        System.out.println("Shots fired: " + ocean.getShotsFired();
        System.out.println("Hits: " + ocean.getHitCount();
        System.out.println("Ships sunk: " + ocean.getShipsSunk();
        
        do {
            System.out.println("Would you like to play again? Y/N");
            replayGame = in.Next();
            if(replayGame == "Y") { //switch statement
                validResponse = true;
                runGame(); //move method
            } else if(replayGame == "N") {
                validResponse = true;
                break;
            } else {
                System.out.println("Invalid response.");
                validResponse = false;
            }
        } while (!(validResponse));

    }
}
