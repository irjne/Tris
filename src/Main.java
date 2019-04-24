import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        int choice;
        Tris tris = new Tris ();

        do
        {
            System.out.println("--- MENU --- \n");
            System.out.println("0- new match; ");
            System.out.println("1- new round; ");
            System.out.println("2- grid; ");
            System.out.println("3- exit. ");

            System.out.print("\nChoice: ");
            Scanner scanIn = new Scanner(System.in);
            choice = scanIn.nextInt();

            switch (choice)
            {
                case 0:
                {
                    System.out.println("--- RESET GRID ---\n");

                    tris.resetGrid();
                }
                break;

                case 1:
                {
                    System.out.println("--- NEW ROUND ---\n");
                    System.out.print("Type your symbol, only 'X' or 'O' accepted: ");
                    Character sign = scanIn.next().charAt(0);
                    System.out.print("Type the position where you want to cross, row: ");
                    int x = scanIn.nextInt();
                    System.out.print("and column: ");
                    int y = scanIn.nextInt();

                    int result=tris.setSignAt(x, y, sign);

                    if (result ==0)
                    {
                        System.out.println("Round accepted.\n");
                        int winner = tris.checkWinner();

                        if (winner==0) System.out.println("Player '"+ tris.getLastSign() +"' wins!\n");
                        else if (winner==1) System.out.println("Match finished in a draw.\n");
                    }
                    else if (result==3) System.out.println("You can't move in position "+x+", "+y+".\n");
                    else if (result==2) System.out.println("It's not your turn.\n");
                    else if (result==1) System.out.println("Invalid sign. Please use 'X' or 'O'.\n");
                }
                break;

                case 2:
                {
                    System.out.println("--- STAMP GRID ---\n");

                    tris.stampGrid();
                }
                break;
                default: System.out.println("Error: invalid choice. Please select an option between 0 and 2.\n");
            }

        } while (choice!=3);
    }
}
