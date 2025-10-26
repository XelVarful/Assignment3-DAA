package algorithms;

import model.Edge;
import model.Graph;

import java.util.*;

public class PrimAlgorithm {
    public static List<Edge> findMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        if (graph.nodes.isEmpty()) return mst;

        String start = graph.nodes.get(0);
        visited.add(start);

        while (visited.size() < graph.nodes.size()) {
            Edge minEdge = null;

            for (Edge e : graph.edges) {
                if (visited.contains(e.from) && !visited.contains(e.to) ||
                        visited.contains(e.to) && !visited.contains(e.from)) {
                    if (minEdge == null || e.weight < minEdge.weight) {
                        minEdge = e;
                    }
                }
            }

            if (minEdge == null) break;

            mst.add(minEdge);
            visited.add(minEdge.from);
            visited.add(minEdge.to);
        }

        return mst;
    }
}
