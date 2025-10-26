package algorithms;

import model.Edge;
import model.Graph;

import java.util.*;

public class KruskalAlgorithm {
    private static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();

        public String find(String node) {
            if (!parent.containsKey(node)) parent.put(node, node);
            if (!parent.get(node).equals(node))
                parent.put(node, find(parent.get(node)));
            return parent.get(node);
        }

        public void union(String a, String b) {
            parent.put(find(a), find(b));
        }
    }

    public static List<Edge> findMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        UnionFind uf = new UnionFind();

        List<Edge> sortedEdges = new ArrayList<>(graph.edges);
        Collections.sort(sortedEdges);

        for (Edge edge : sortedEdges) {
            String root1 = uf.find(edge.from);
            String root2 = uf.find(edge.to);

            if (!root1.equals(root2)) {
                mst.add(edge);
                uf.union(root1, root2);
            }
        }

        return mst;
    }
}
