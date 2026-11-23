public class Board {

    final int[][] knightMoves = new int[][]{
        {-2,-1},
        {-2,1},
        {-1,-2},
        {-1,2},
        {1,-2},
        {1,2},
        {2,-1},
        {2,1}
    };

    Square[][] board;

    public Board(int size){
        board = new Square[size][size];
        
        // create squares
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new Square(i,j);
            }
        }

        // create links
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int[] move : knightMoves){
                    int k = i + move[0];
                    int l = j + move[1];
                    if(0 <= k && k < size && 0 <= l && l < size){
                        board[i][j].addNeighbor(board[k][l]);
                    }
                }
            }
        }

    }

    public Square getStart(){
        return board[0][0];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                sb.append(board[i][j].visited ? "!" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
