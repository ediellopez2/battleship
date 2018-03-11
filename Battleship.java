import java.util.Random;
public class Battleship {

    // Fields
    // ***********************************
    private char[][] table;
    private int machine;
    private int human;
    // ***********************************

    // Default Constructor
    Battleship(){
       /* table = new char[][]{{'_','1','2','3','4','5','_'},
                             {'1','_','_','_','_','_','1'},
                             {'2','_','_','_','_','_','2'},
                             {'3','_','_','_','_','_','3'},
                             {'4','_','_','_','_','_','4'},
                             {'5','_','_','_','_','_','5'},
                             {'_','1','2','3','4','5','_'}};*/
        /*machine = 5;
        human = 5;*/
        table = new char[][]{{'_','1','2','3','4','_'},
                             {'1','_','_','_','_','1'},
                             {'2','_','_','_','_','2'},
                             {'3','_','_','_','_','3'},
                             {'4','_','_','_','_','4'},
                             {'_','1','2','3','4','_'}};
        machine = 3;
        human = 3;
    }

    // Methods
    // *******************************************************
    // *******************************************************

    public int getMachine() {
        return machine;
    }

    public int getHuman() {
        return human;
    }

    public void getWelcomeMessage(){
        System.out.println("*****************************************************");
        System.out.println("***          Battleship: Man vs. Machine          ***");
        System.out.println("*** Who will win, Man or Machine? CAPT Phillips,  ***");
        System.out.println("*** ready your fleet and prepare to go up against ***");
        System.out.println("*** the most advanced AI known to man, the        ***");
        System.out.println("*** Maverick 1. Best of luck to you, Captain!     ***");
        System.out.println("*****************************************************");
    }

    public void printTable(){
        for(int row = 0; row < table.length; row++)
        {
            for(int column = 0; column < table[0].length; column++)
            {
                System.out.print("\t");
                System.out.print(' ');
                if(Character.getNumericValue(table[row][column]) == -1 ||
                        Character.getNumericValue(table[row][column]) == 33)
                    System.out.print(' ');
                else
                    System.out.print(table[row][column]);
            }
            System.out.println();
        }
    }

    public char getValue(int x,int y)
    {
        return table[x][y];
    }

    public void modifyTable(int x, int y)
    {
        table[x][y] = 'O';
    }

    // Use a Random Number Generator (AI)
    // to deploy the enemies ships
   public void smartAI()
    {
        System.out.println("\n\n\t**************************************");
        System.out.println("\t*** THE AI HAS DEPLOYED ITS SHIPS! ***");
        System.out.println("\t**************************************\n");
        Random randomNumber = new Random();

        int rand_x = randomNumber.nextInt(4) + 1;
        int rand_y = randomNumber.nextInt(4) + 1;

        for (int count = 0; count < 3; count++)
        {
            // After the player has deployed its ships,
            // it the AIs turn. The AI will generate two random
            // numbers (shown above). Before deploying its ships,
            // the AI will ensure that there isn't already a ship
            // in the destination slot, be it a ship from the user
            // or one of its own.
            while (table[rand_x][rand_y] == 'O' ||
                    table[rand_x][rand_y] == 'X')
            {
                rand_x = randomNumber.nextInt(4) + 1;
                rand_y = randomNumber.nextInt(4) + 1;
            }

            table[rand_x][rand_y] = 'X';
        }
    }

    // Attack the enemies ship
    public void captainAttack(int x, int y)
    {
        if(table[x][y] == 'X')
        {
            machine--;
            System.out.println("\n\t** RESULT: Direct hit, Captain! **");
            System.out.println("\t**********************************");
            System.out.println("\t***          Carriers          ***");
            System.out.println("\t***  Maverick 1: " + machine + "             ***");
            System.out.println("\t***  CAPT Philips: " + human + "           ***");
            System.out.println("\t**********************************");
            table[x][y] = 'u';
        }
        else{
            System.out.println("\t*** RESULT: You missed, Captain! ***");
            System.out.println("\t************************************");
            System.out.println("\t***           Carriers           ***");
            System.out.println("\t***   Maverick 1: " + machine + "              ***");
            System.out.println("\t***   CAPT Philips: " + human + "            ***");
            System.out.println("\t************************************");
        }
    }

    // The AI will attempt to destroy the Captain's ship
    public void machineAttack()
    {
        Random randomNumber = new Random();

        int rand_x = randomNumber.nextInt(4) + 1;
        int rand_y = randomNumber.nextInt(4) + 1;

        while (table[rand_x][rand_y] == 'X')
        {
            rand_x = randomNumber.nextInt(4) + 1;
            rand_y = randomNumber.nextInt(4) + 1;
        }

        //System.out.println("  " + rand_x + "   " + rand_y);

        if (table[rand_x][rand_y] == 'O'){
            human--;
            System.out.println("\n\t*** RESULT: Direct hit! Captain, ***");
            System.out.println("\t*** you've lost a ship!          ***");
            System.out.println("\t************************************");
            System.out.println("\t***           Carriers           ***");
            System.out.println("\t***   Maverick 1: " + machine + "              ***");
            System.out.println("\t***   CAPT Philips: " + human + "            ***");
            System.out.println("\t************************************");
            table[rand_x][rand_y] = 'v';

        }
        else
        {
            System.out.println("\n\t*** RESULT: The AI missed, phew! ***");
            System.out.println("\t************************************");
            System.out.println("\t***           Carriers           ***");
            System.out.println("\t***   Maverick 1: " + machine + "              ***");
            System.out.println("\t***   CAPT Philips: " + human + "            ***");
            System.out.println("\t************************************");
        }
    }

    public void scoreBoard()
    {
        System.out.println("\n\t**********************************");
        System.out.println("\t***          Carriers          ***");
        System.out.println("\t***  Maverick 1: " + machine + "             ***");
        System.out.println("\t***  CAPT Philips: " + human + "           ***");
        System.out.println("\t**********************************");
    }
    // *******************************************************
    // *******************************************************
}
