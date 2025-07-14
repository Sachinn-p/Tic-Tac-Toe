import  java.util.*;

public  class  Board{
    char[][] board = new char[3][3];

    public Board() {
        for(char[] row : board){
            Arrays.fill(row, ' ');
        } 
    }
    
    void printBoard(){
        for( char[] row : board){
            for (char c : row){
                System.err.print("|" + c);
            }
        System.out.println("|");
        }
    }

    boolean placeSymbol(int row, int col, char symbol){
    if (row < 0 || row > 2 || col < 0 || col > 2) return false;
    if (board[row][col] != ' ') return false;
    board[row][col] = symbol;
    return true;
}

    boolean isFull(){
        for (char[] row: board){
            for (char c : row){
                if( c == ' ') return false;
            }
        }
        return  true;
    }


    
}