public class Tris
{
    private Character [][] grid;
    private Character lastSign;

    public Tris ()
    {
        this.grid = new Character [3][3];
    }

    public Character getLastSign() {return lastSign;}

    //implementare un metodo che permetta di inserire un segno tenendo conto del turno di gioco, del segno da inserire
    //e dell'eventuale posizione occupata.

    public int setSignAt (int x, int y, Character sign)
    {
        if (sign=='x' || sign=='o')
        {
            if (sign!=this.lastSign)
            {
                if (this.grid[x][y]==null)
                {
                    this.grid[x][y]=sign;
                    this.lastSign=sign;
                    return 0; //turno accettato
                }
                else return 3; //posizione occupata
            }
            else return 2; //turno sbagliato
        }
        else return 1; //segno non valido
    }

    // implementare un metodo che verifichi se sia avvenuto un pareggio o che nessuno dei due giocatori sia giunto
    // alla vittoria in una delle otto combinazioni possibili.

    public int checkWinner ()
    {
        boolean flag=true;

        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
            {
                if (grid[i][j]==null) flag = false;
            }

        if (grid[0][0]!=null && grid[0][0].equals(grid[0][1]) && grid[0][0].equals(grid[0][2])) return 0; //prima riga
        else if (grid[1][0]!=null && grid[1][0].equals(grid[1][1]) && grid[1][0].equals(grid[1][2])) return 0; //seconda riga
        else if (grid[2][0]!=null && grid[2][0].equals(grid[2][1]) && grid[2][0].equals(grid[2][2])) return 0; //terza riga
        else if (grid[0][0]!=null && grid[0][0].equals(grid[1][0]) && grid[0][0].equals(grid[2][0])) return 0; //prima colonna
        else if (grid[0][1]!=null && grid[0][1].equals(grid[1][1]) && grid[0][1].equals(grid[2][1])) return 0; //seconda colonna
        else if (grid[0][2]!=null && grid[0][2].equals(grid[1][2]) && grid[0][2].equals(grid[2][2])) return 0; //terza colonna
        else if (grid[0][0]!=null && grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) return 0; //prima diagonale
        else if (grid[0][2]!=null && grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0])) return 0; //seconda diagonale
        else if (flag) return 1;
        else return -1;
    }

    //implementare un metodo che resetti la griglia di gioco cancellando ogni segno effettuato.

    public void resetGrid ()
    {
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
            {
                this.grid[i][j]=null;
                this.lastSign=null;
            }
    }

    //implementare un metodo che permetta di visualizzare a video la griglia di gioco, senza rappresentare i NULL.
    // La pipe è facoltatitva.

    public void stampGrid ()
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (this.grid[i][j]!=null) System.out.print("|\t" + this.grid[i][j] + "\t");
                else System.out.print("|\t \t");
            }
            System.out.print("|\n");
        }
    }
}