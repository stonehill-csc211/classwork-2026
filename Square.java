import java.util.ArrayList;
import java.util.List;

public class Square {
    List<Square> neighbors;
    boolean visited;
    Square predecessor;
    int i,j;

    public Square(int i, int j){
        this.visited = false;
        this.i = i;
        this.j = j;
        neighbors = new ArrayList<Square>();
    }

    public void addNeighbor(Square other){
        neighbors.add(other);
    }

    public List<Square> getNeighbors(){
        return neighbors;
    }
    public String toString(){
        return i + " " + j;
    }
}
