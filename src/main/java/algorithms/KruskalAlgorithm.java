package algorithms;

import model.Edge;
import model.Graph;
import java.util.*;

public class KruskalAlgorithm {

    private static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();

        public void makeSet(List<String> vertices) {
            for (String v : vertices) parent.put(v, v);
        }

        public String find(String v) {
            if (!parent.get(v).equals(v))
                parent.put(v, find(parent.get(v)));
            return parent.get(v);
        }

        public void union(String v1, String v2) {
            String root1 = find(v1);
            String root2 = find(v2);
            if (!root1.equals(root2))
                parent.put(root2, root1);
        }
    }

    public static List<Edge> findMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        UnionFind uf = new UnionFind();
        uf.makeSet(graph.getVertices());

        List<Edge> edges = new ArrayList<>(graph.getEdges());
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        for (Edge e : edges) {
            if (!uf.find(e.getFrom()).equals(uf.find(e.getTo()))) {
                uf.union(e.getFrom(), e.getTo());
                mst.add(e);
            }
        }

        return mst;
    }

    public static int calculateTotalWeight(List<Edge> mst) {
        return mst.stream().mapToInt(Edge::getWeight).sum();
    }
}
