package model;

import java.util.*;

public class Graph {
    private List<String> vertices;
    private List<Edge> edges;

    public Graph(List<String> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<String> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(String from, String to, int weight) {
        edges.add(new Edge(from, to, weight));
    }
}
