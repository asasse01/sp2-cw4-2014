/**
 * Created by abby on 22/12/14.
 */
 
 import java.util.Scanner;
 public class BattleshipGame {


    public static void main(String[] args) {        
        
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        
        runGame(ocean);
        requestReplay(ocean);
        
       
    }
    
    static void runGame(Ocean ocean) {
    	Scanner in = new Scanner(System.in);
        
        boolean shot = false;
        int x;
        int y;
        
         System.out.println("Welcome to the Battleship Game.");
         ocean.print();
        
        do {
            
            System.out.println("Please enter your shots, giving coordinates x and y on a new line");
            x = in.nextInt();
            y = in.nextInt();
            
            shot = ocean.shootAt(x, y);
            if(shot){
                if(ocean.ships[x][y].isSunk()){// TODO create Ocean method
                    System.out.println("You just sunk a "+ ocean.ships[x][y].getShipType());
                } else System.out.println("Hit");
            } else System.out.println("Miss");
            ocean.print();    
        } while (!(ocean.isGameOver()));
        
        System.out.println("Game completed. Final Score (shots fired): " + ocean.getShotsFired());
        
        in.close();
    }
    
    static void requestReplay(Ocean ocean) {
    	Scanner in = new Scanner(System.in);
    	
        String replayGame;
        boolean validResponse = true;

        do {
            System.out.println("Would you like to play again? Y/N");
            replayGame = in.next();
            if(replayGame == "Y") { //switch statement
                validResponse = true;
                runGame(ocean);
            } else if(replayGame == "N") {
                validResponse = true;
                break;
            } else {
                System.out.println("Invalid response.");
                validResponse = false;
            }
        } while (!(validResponse));
        
        in.close();
    }
}
