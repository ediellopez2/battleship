import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        // *************************************
        Scanner input = new Scanner(System.in);
        Battleship player = new Battleship();
        int x;      // x-coordinate
        int y;      // y-coordinate
        // *************************************

        // Introduction
        player.getWelcomeMessage();
        player.printTable();


        player.scoreBoard();

        // ************************************************************
        // ************************************************************
        System.out.println("\nCaptain, deploy your ships:");
        for (int count = 1; count < 4; count++)
        {
            System.out.print("Ship #" + count + " - Row: ");
            x = input.nextInt(); input.nextLine();
            while(x < 1 || x > 4) {
                System.out.print("Ship #" + count + " - Row: ");
                x = input.nextInt();
                input.nextLine();
            }
            System.out.print("Ship #" + count + " - Column: ");
            y = input.nextInt(); input.nextLine();
            while(y < 1 || y > 4) {
                System.out.print("Ship #" + count + " - Column: ");
                y = input.nextInt();
                input.nextLine();
            }

            if (player.getValue(x,y) == 'O')
            {
                System.out.println("*******************************************");
                System.out.println("*** ERROR! Coordinate is already taken! ***");
                System.out.println("*******************************************");
                count--;
            }
            else
                player.modifyTable(x,y);
        }
        // ************************************************************
        // ************************************************************

        player.smartAI();

        System.out.println("\t*******************************************");
        System.out.println("\t*** All ships have been deployed! May   ***");
        System.out.println("\t*** the odds be in your favor, Captain! ***");
        System.out.println("\t*** Humanity is counting on you!        ***");
        System.out.println("\t*******************************************\n");

        player.printTable();

        // THE GAME
        // *****************************************************
        // *****************************************************
        int x_destination;
        int y_destination;

        boolean status = true;
        // player.getMachine() > 0 || player.getHuman() > 0
        while (status)
        {
            // PLAYER
            // *********************************************************
            // *********************************************************
            System.out.println("\nCaptain, select your target: ");
            System.out.print("Row: ");
            x_destination = input.nextInt(); input.nextLine();
            while(x_destination < 1 || x_destination > 4) {
                System.out.print("Row: ");
                x_destination = input.nextInt();
                input.nextLine();
            }

            System.out.print("Column: ");
            y_destination = input.nextInt(); input.nextLine();
            while(y_destination < 1 || y_destination > 4) {
                System.out.print("Column: ");
                y_destination = input.nextInt();
                input.nextLine();
            }

            if (player.getValue(x_destination,y_destination) == 'O')
            {
                System.out.println("\n*************************************************");
                System.out.println("*** WARNING! You cannot attack your own ship! ***");
                System.out.println("*************************************************");
                continue;
            }
            else {
                player.captainAttack(x_destination,y_destination);
                player.printTable();
            }
            // **********************************************************
            // **********************************************************

            // AI
            // *********************************************************************
            System.out.println("\n\t***********************************************");
            System.out.println("\t*** The AI is selecting a target! Be ready! ***");
            System.out.println("\t***********************************************");
            player.machineAttack();
            // **********************************

            /*System.out.println(player.getMachine());
            System.out.println(player.getHuman());*/

            if (player.getMachine() == 0)
                status = false;
            if (player.getHuman() == 0)
                status = false;

        }
        // *****************************************************
        // *****************************************************

       if (player.getMachine() == 0) {
           System.out.println("\n\t**********************************");
           System.out.println("\t***           WINNER:          ***");
           System.out.println("\t***      Captain Phillips      ***");
           System.out.println("\t**********************************");

           //player.scoreBoard();
       }
       else
       {
           System.out.println("\n\t**********************************");
           System.out.println("\t***           WINNER:          ***");
           System.out.println("\t***         Maverick 1         ***");
           System.out.println("\t**********************************");
           //System.out.println("\tInitiating nuclear missiles .... ");
           //player.scoreBoard();
       }

    }
}
