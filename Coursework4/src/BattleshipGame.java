/**
 * @author Abby Sassel
 * @since 22/12/14
 * 
 * SP2 Coursework 4
 * - Single player battleship game
 * - The computer places the ships, and the human attempts to sink them.
 */
 
 import java.util.Scanner;
 public class BattleshipGame {
	 
	public static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {        
        
        do {
        	runGame();
        } while(replayRequested());
        
        IN.close();
       
    }
    
    /**
     * runs Battleship game, recording hit and sunk ships until game completion
     * @param ocean in which to run the game
     */
    static void runGame() {
    	Ocean ocean = new Ocean();
    	ocean.placeAllShipsRandomly();
        
        boolean shot = false;
        int x;
        int y;
        
         System.out.println("Welcome to the Battleship Game.");
         ocean.print();
        
        do {
            
            int coord[] = formatInput(requestInput());
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
    
    /**
     * requests and checks user input coordinates 
     * @return user input to pass to Battleship game
     */
    static String requestInput() {
        boolean validInput = false;
        String correctFormat = "\\d{1}\\,\\s*\\d{1}";
        String input;
    	
        do {
	        System.out.println("Please enter your shot, giving coordinates 0-9 in the format \"x, y\"");
	        input = IN.nextLine();
	        
	        if(!(input.matches(correctFormat))) {
	        	System.out.println("Sorry, wrong format or coordinates outside of board.");
	        } else validInput = true;
        } while (!(validInput));
    	
        return input;
        
    }
    
    /**
     * parses user input String into array for use in Battleship game
     * @param input user input String to convert to array
     * @return array coordinates or use in Battleship game
     */
    static int[] formatInput(String input) {
    	int coord[] = new int[2];
        String inputSplit[] = input.split("\\,\\s*");
        coord[0] = Integer.parseInt(inputSplit[0]);
        coord[1] = Integer.parseInt(inputSplit[1]); 
        return coord;
    }

    /**
     * prompts the user to replay the game on completion and loops main method 
     * @param ocean
     */
    static boolean replayRequested() {
        String replayGame;
        boolean validResponse = true;
        boolean replay = false;

        do {
            System.out.println("Would you like to play again? Y/N");
            replayGame = IN.next().toUpperCase();
            switch(replayGame) {
            case("Y"):
            	validResponse = true;
            	replay = true;
            case("N"):
            	validResponse = true;
            	System.out.println("Thanks for playing Battleship!");
            	break;
        	default:
        		System.out.println("Invalid response. Please enter \"Y\" or \"N\".");
                validResponse = false;
            }
        } while (!(validResponse));
        
        return replay;
    }
    
    /**
     * runs game with sequential hits for use in testing only
     * @param ocean in which to run the game
     */
    static void testRunGame() {
    	Ocean ocean = new Ocean();
    	ocean.placeAllShipsRandomly();
        
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
		            ocean.print(); 
        		}
        	}
        } while (!(ocean.isGameOver()));
        ocean.print();
        System.out.println("Game completed. Final Score (shots fired): " + ocean.getShotsFired());
        
    }
}
