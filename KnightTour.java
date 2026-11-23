import java.util.LinkedList;
import java.util.List;

public class KnightTour {

    int failures;
    int successes;
    final int size;

    Board b;
    public KnightTour(int size){
        this.size = size;
        b = new Board(size);
        failures = 0;
    }


    public LinkedList<Square> solve(Square current, int depth){
        // base case -- if depth is deep enough, we're done
        if(depth == size * size){ 
            LinkedList<Square> retval = new LinkedList<Square>();
            retval.add(current);
            return retval; 
        } else{
            current.visit();
            LinkedList<Square> result;

            // try each neighbor
            for(Square neighbor : current.getNeighbors()){
                if(!neighbor.visited) result = solve(neighbor, depth + 1);
                else continue;
                // if we succeeded, add the current square to the start
                if(result != null){
                    result.addFirst(current);
                    return result;
                }
            }
            // if we reach the end of the loop, this is a failed path
            current.visited = false;
            failures++;
            return null;
        }

    }

    public static void main(String[] args){
        int size = 20;
        KnightTour kt = new KnightTour(size);
        List<Square> solution = kt.solve(kt.b.getStart(), 1);
        System.out.println(size + " solved with " + kt.failures + " failed paths.");
        for(Square square : solution){
            System.out.println(square);
        }
        
    }
}
