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
                if(ocean.getShipAt(x, y).isSunk()){
                    System.out.println("You just sunk a "+ ocean.getShipAt(x, y).getShipType());
                } else System.out.println("Hit");
            } else System.out.println("Miss");
            ocean.print();    
        } while (!(ocean.isGameOver()));
        
        System.out.println("Game completed. Final Score (shots fired): " + ocean.getShotsFired());
        
    }
    
    static int[] requestInputCoord() {
    	int coord[] = new int[2];
        boolean validInput = false;
        String correctFormat = "\\d{1}\\,\\s*\\d{1}";
        String input;
    	
        do {
	        System.out.println("Please enter your shot, giving coordinates 0-9 in the format \"x, y\"");
	        input = IN.nextLine();
	        
	        if (input == correctFormat) {
	            validInput = true;
	        } else {
	            System.out.println("Sorry, wrong format.");
	        } 
        } while (!validInput);
    	
        String inputSplit[] = input.split("\\,\\s*");
        coord[0] = Integer.parseInt(inputSplit[0]);
        coord[1] = Integer.parseInt(inputSplit[1]);
                
        return coord;

    }
    
    static void requestReplay(Ocean ocean) {
    	
        String replayGame;
        boolean validResponse = true;

        do {
            System.out.println("Would you like to play again? Y/N");
            replayGame = IN.next().toUpperCase();
            switch(replayGame) {
            case("Y"):
            	validResponse = true;
            	runGame(ocean);
            case("N"):
            	validResponse = true;
            	System.out.println("Thanks for playing Battleship!");
            	break;
        	default:
        		System.out.println("Invalid response. Please enter \"Y\" or \"N\".");
                validResponse = false;
            }
        } while (!(validResponse));
        
    }
    
    static void testRunGame(Ocean ocean) {
        
        boolean shot = false;
        
         System.out.println("Welcome to the Battleship Game TEST.");
         ocean.print();
        
        do {
        	for(int i = 0; i < 10; i++) {
        		for(int j = 0; j < 10; j++) {
		            shot = ocean.shootAt(i, j);
		            if(shot){
		                if(ocean.getShipAt(i, j).isSunk()){
		                    System.out.println("You just sunk a "+ ocean.getShipAt(i, j).getShipType());
		                } else System.out.println("Hit");
		            } else System.out.println("Miss");
		            //ocean.print(); 
        		}
        	}
        } while (!(ocean.isGameOver()));
        ocean.print();
        System.out.println("Game completed. Final Score (shots fired): " + ocean.getShotsFired());
        
    }
}
