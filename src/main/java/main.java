import algorithms.KruskalAlgorithm;
import algorithms.PrimAlgorithm;
import model.Edge;
import model.Graph;
import utils.JsonIO;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Graph graph = JsonIO.readGraphFromJson("input.json");

        List<Edge> primMST = PrimAlgorithm.findMST(graph);
        List<Edge> kruskalMST = KruskalAlgorithm.findMST(graph);

        int primWeight = PrimAlgorithm.calculateTotalWeight(primMST);
        int kruskalWeight = KruskalAlgorithm.calculateTotalWeight(kruskalMST);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("Prim_MST", primMST);
        result.put("Prim_TotalWeight", primWeight);
        result.put("Kruskal_MST", kruskalMST);
        result.put("Kruskal_TotalWeight", kruskalWeight);

        JsonIO.writeResultToJson("output.json", result);

        System.out.println("✅ Prim Total Weight: " + primWeight);
        System.out.println("✅ Kruskal Total Weight: " + kruskalWeight);
    }
}
