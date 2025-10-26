package algorithms;

import model.Edge;
import model.Graph;

import java.util.*;

public class PrimAlgorithm {
    public static List<Edge> findMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        String start = graph.getVertices().get(0);
        visited.add(start);
        for (Edge e : graph.getEdges()) {
            if (e.getFrom().equals(start) || e.getTo().equals(start))
                pq.add(e);
        }

        while (!pq.isEmpty() && mst.size() < graph.getVertices().size() - 1) {
            Edge edge = pq.poll();
            String nextVertex = visited.contains(edge.getFrom()) ? edge.getTo() : edge.getFrom();

            if (!visited.contains(nextVertex)) {
                mst.add(edge);
                visited.add(nextVertex);

                for (Edge e : graph.getEdges()) {
                    if (visited.contains(e.getFrom()) ^ visited.contains(e.getTo()))
                        pq.add(e);
                }
            }
        }

        return mst;
    }

    public static int calculateTotalWeight(List<Edge> mst) {
        return mst.stream().mapToInt(Edge::getWeight).sum();
    }
}
