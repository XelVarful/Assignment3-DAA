import java.util.*;

public class KruskalAlgorithm {

    static class DisjointSet {
        private final Map<String, String> parent = new HashMap<>();
        private final Map<String, Integer> rank = new HashMap<>();
        public int operations = 0;

        public DisjointSet(List<String> nodes) {
            for (String node : nodes) {
                parent.put(node, node);
                rank.put(node, 0);
            }
        }

        public String find(String node) {
            operations++;
            if (!parent.get(node).equals(node)) {
                parent.put(node, find(parent.get(node)));
            }
            return parent.get(node);
        }

        public void union(String a, String b) {
            operations++;
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB)) {
                if (rank.get(rootA) < rank.get(rootB)) {
                    parent.put(rootA, rootB);
                } else if (rank.get(rootA) > rank.get(rootB)) {
                    parent.put(rootB, rootA);
                } else {
                    parent.put(rootB, rootA);
                    rank.put(rootA, rank.get(rootA) + 1);
                }
            }
        }
    }

    public static Map<String, Object> findMST(Graph graph) {
        long startTime = System.currentTimeMillis();
        List<Edge> sortedEdges = new ArrayList<>(graph.edges);
        Collections.sort(sortedEdges);

        DisjointSet ds = new DisjointSet(graph.nodes);
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        for (Edge e : sortedEdges) {
            if (!ds.find(e.from).equals(ds.find(e.to))) {
                ds.union(e.from, e.to);
                mstEdges.add(e);
                totalCost += e.weight;
            }
        }

        long execTime = System.currentTimeMillis() - startTime;

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("edges", mstEdges);
        result.put("total_cost", totalCost);
        result.put("operations", ds.operations);
        result.put("execution_time_ms", execTime);
        return result;
    }
}
