/**
 * Created by abby on 22/12/14.
 */
 
 import java.util.Scanner;
 public class BattleshipGame {
	 
	public static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {        
        
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        
        runGame(ocean);
        requestReplay(ocean);
        
        IN.close();
       
    }
    
    static void runGame(Ocean ocean) {
        
        boolean shot = false;
        int x;
        int y;
        
         System.out.println("Welcome to the Battleship Game.");
         ocean.print();
        
        do {
            
            int coord[] = requestInputCoord();
            x = coord[0];
            y = coord[1];
            shot = ocean.shootAt(x, y);
            if(shot){
                if(ocean.ships[x][y].isSunk()){// TODO create Ocean method
                    System.out.println("You just sunk a "+ ocean.ships[x][y].getShipType());
                } else System.out.println("Hit");
            } else System.out.println("Miss");
            ocean.print();    
        } while (!(ocean.isGameOver()));
        
        System.out.println("Game completed. Final Score (shots fired): " + ocean.getShotsFired());
        
    }
    
    static int[] requestInputCoord() {
    	int coord[] = new int[2];
    	
        System.out.println("Please enter your shot, giving coordinates in the format \"x, y\"");
        // TODO error checking
    	String input[] = IN.nextLine().split("\\,\\s?+");
        coord[0] = Integer.parseInt(input[0]);
        coord[1] = Integer.parseInt(input[1]);
                
        return coord;

    }
    
    static void requestReplay(Ocean ocean) {
    	
        String replayGame;
        boolean validResponse = true;

        do {
            System.out.println("Would you like to play again? Y/N");
            replayGame = IN.next();
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
        
    }
}
