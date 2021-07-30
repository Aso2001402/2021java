public static void displayRiver(int[] river, boolean showShip) {
    System.out.println();
    System.out.print("|");
    for (int val : river) {
        switch (val) {
            case -1: // No Ship
            System.out.print("x");
            break;
            case 0: // Unknown
            System.out.print(" ");
            break;
            case 1: // Ship Found
            System.out.print(showShip ? "Y" : " ");
            break;
        }//switch
        System.out.print("|");
    }//for
    System.out.println();
    System.out.println();
}//displayRiver

// main method
public static void main(String[] arg) {
    int riverLength = promptForInt("Please, enter the river lenght"); 
    int [] shipArray = new int[riverLength]; 
 
    int randomBattleshipLocation = new Random().nextInt(riverLength); 
    shipArray[randomBattleshipLocation] = 1; 
 
    boolean showShip = false ; 
    int userGuess; 

    do
    {
        displayRiver (shipArray, false);
        userGuess = promptForInt(String.format("Guess, enter a location from 1 to " + riverLength));
        userGuess = userGuess -1; 

        if(shipArray[userGuess] == 1) 
        {
            System.out.println("");
            showShip = true; 
            displayRiver(shipArray, true);
        }
        else if(shipArray[userGuess] == -1)
        {
            System.out.println("");
        }
        else if(shipArray[userGuess] == 0) 
        {
            System.out.println("沈没...");
            shipArray[userGuess] = -1 ; 
        }

    } while(!showShip); 

    System.exit(0);

}
}