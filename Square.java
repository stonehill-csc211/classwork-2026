import java.util.ArrayList;
import java.util.List;

public class Square {
    List<Square> neighbors;
    int nUnvisitedNeighbors;
    boolean visited;
    int i,j;

    public Square(int i, int j){
        this.visited = false;
        this.i = i;
        this.j = j;
        nUnvisitedNeighbors = 0;
        neighbors = new ArrayList<Square>();
    }

    public void addNeighbor(Square other){
        neighbors.add(other);
        nUnvisitedNeighbors++;
    }

    public void visit(){
        this.visited = true;
        for(Square neighbor : neighbors){
            neighbor.nUnvisitedNeighbors--;
        }
    }

    public List<Square> getNeighbors(){
        ArrayList<Square> retval = new ArrayList<>();
        int nNeighbors;
        for(Square neighbor : neighbors){
            nNeighbors = neighbor.nUnvisitedNeighbors;
            for(int i = 0; i < retval.size(); i++){
                if(retval.get(i).nUnvisitedNeighbors > nNeighbors){
                    retval.add(i, neighbor);
                    break;
                }
            }
            retval.add(neighbor);
        }
        return retval;
    }
    public String toString(){
        return i + " " + j;
    }
}
