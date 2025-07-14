

import java.util.Scanner;

public class TicTacToe{
    Player p1, p2;
    Board board;
    Scanner sc = new Scanner(System.in);


    public TicTacToe() {
        System.out.print("Enter Player 1 name: ");
        this.p1 = new Player(sc.nextLine(), 'X');    
        System.out.print("Enter Player 2 name: ");
        this.p2 = new Player(sc.nextLine(), 'O');

        this.board = new Board();
    }

    public void play(){
        Player current = this.p1;

        while (true) { 
            board.printBoard();
            System.out.println(current.name + "'s Turn(" + current.symbol + ")");
            System.out.print("Enter the row and col number (1 - 2):");
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean horizontal, vertical, diagonal1, diagonal2;
            if(board.placeSymbol(row, col, current.symbol)){
                 horizontal = board.board[row][0] == current.symbol &&
                                     board.board[row][1] == current.symbol &&
                                     board.board[row][2] == current.symbol;

                 vertical = board.board[0][col] == current.symbol &&
                                   board.board[1][col] == current.symbol &&
                                   board.board[2][col] == current.symbol;

                 diagonal1 = row == col &&
                                    board.board[0][0] == current.symbol &&
                                    board.board[1][1] == current.symbol &&
                                    board.board[2][2] == current.symbol;

                 diagonal2 = row + col == 2 &&
                                    board.board[0][2] == current.symbol &&
                                    board.board[1][1] == current.symbol &&
                                    board.board[2][0] == current.symbol;

            

            if(horizontal || vertical || diagonal1 || diagonal2){
                board.printBoard();
                System.out.println( current.name + "wins...!");
                break;
            }

            if(board.isFull()){
                board.printBoard();
                System.out.println("Game Draw");
                break;
            }
            current = (current == p1) ? p2 : p1;
        }else {
            System.err.println("Ivalid move try again..!");
        }
    }

}

    public static void main(String[] args) {
        new TicTacToe().play();
    }

   
    
}