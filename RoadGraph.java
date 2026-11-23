import java.util.ArrayList;
import java.util.HashMap;
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
        // TODO
    }

    /**
     * Get the distance between two neighboring towns
     */
    public int getDistance(String town1, String town2){
        // TODO
    }

    /**
     * Get the shortest path from one town to another
     */
    public String[] shortestPath(String start, String end){
        // TODO
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
