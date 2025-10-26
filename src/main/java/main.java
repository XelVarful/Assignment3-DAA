
import algorithms.KruskalAlgorithm;
import algorithms.PrimAlgorithm;
import model.Edge;
import model.Graph;
import utils.JsonIO;

import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Graph> graphs = JsonIO.readGraphs("input.json");
        Map<Integer, List<Edge>> outputData = new HashMap<>();

        for (Graph graph : graphs) {
            System.out.println("Processing Graph ID: " + graph.id);
            List<Edge> mst = KruskalAlgorithm.findMST(graph);
            outputData.put(graph.id, mst);

            mst.forEach(System.out::println);
            System.out.println("--------------------");
        }

        JsonIO.writeResults("output.json", outputData);
        System.out.println("Results saved to output.json");
    }
}
