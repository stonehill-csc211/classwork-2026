import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RoadGraph {

    HashMap<String,Integer> nameToIndex;
    ArrayList<String> names;
    int[][] distances;

    public RoadGraph(Scanner sc){
        nameToIndex = new HashMap<>();
        names = new ArrayList<>();

        String[] firstLine = sc.nextLine().split(",");
        for(int i = 1; i < firstLine.length; i++){
            names.add(firstLine[i]);
            nameToIndex.put(firstLine[i], i-1);
        }

        distances = new int[nameToIndex.size()][nameToIndex.size()];

        String[] row;
        int j = 0;
        while(sc.hasNextLine()){
            row = sc.nextLine().split(",");
            for(int i = 1; i < row.length; i++){
                distances[j][i-1] = Integer.parseInt(row[i]);
            }
            j++;
        }
    }

    /**
     * Get an array of neighbors for a town
     */
    public String[] getNeighbors(String town){
        // get the index for the town name
        int index = nameToIndex.get(town);
        ArrayList<Integer> indices = new ArrayList<>();
        // loop over the corresponding row of the adjacency matrix
        for(int j = 0; j < distances[index].length; j++){
            // collect the index values for the nonzero elements
            if(distances[index][j] != 0){
                indices.add(j);
            }
        }
            
        // convert each index value back to a town name
        String[] neighbors = new String[indices.size()];
        for(int i = 0; i < indices.size(); i++){
            neighbors[i] = this.names.get(indices.get(i));
        }
        return neighbors;
    }

    /**
     * Get the distance between two neighboring towns
     */
    public int getDistance(String town1, String town2){
        int i = nameToIndex.get(town1);
        int j = nameToIndex.get(town2);
        return distances[i][j];
    }

    private class Record implements Comparable<Record>{
        String townName;
        int distance;

        public Record(String townName, int distance){
            this.townName = townName;
            this.distance = distance;
        }

        public int compareTo(Record other){
            return this.distance - other.distance;
        }
    }

    /**
     * Get the shortest path from one town to another
     */
    public String[] shortestPath(String start, String end){
        HashMap<String, String> predecessor = new HashMap<>();
        PriorityQueue<Record> queue = new PriorityQueue<>();
        queue.add(new Record(start, 0));
        while(!queue.isEmpty()){
            Record currentRecord = queue.remove();
            String currentTown = currentRecord.townName;
            int currentDistance = currentRecord.distance;
            if(currentTown.equals(end)){
                System.out.println("Solved it with distance " + currentDistance);
                return new String[0]; //recoverSolution(predecessor);
            }
            for(String neighbor : this.getNeighbors(currentTown)){
                queue.add(
                    new Record(
                        neighbor, 
                        currentDistance + getDistance(currentTown, neighbor)
                ));
                predecessor.put(neighbor, currentTown);
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < distances.length; i++){
            sb.append(names.get(i) + ",");
            for(int j = 0; j < distances[i].length; j++){
                sb.append(distances[i][j] + ",");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        try {
            RoadGraph rg = new RoadGraph(new Scanner(new File("ma_map.csv")));
            System.out.println(rg);
            rg.shortestPath("Taunton", "Holbrook");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
