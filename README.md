# Assignment 3 — Optimization of a City Transportation Network (Minimum Spanning Tree)

## 1. Introduction
This project is part of the Data Structures and Algorithms course.  
The main goal is to implement algorithms that find the **Minimum Spanning Tree (MST)** in a weighted undirected graph.  
The MST connects all districts (vertices) with the minimum possible total cost of construction and without forming cycles.

In this assignment, two algorithms are used and compared:
- **Kruskal’s Algorithm**
- **Prim’s Algorithm**

Both algorithms were applied to graphs provided in `input.json`, and results were written to `output.json`.

---

## 2. Objective
The purpose of this project is to:
- Understand how MST algorithms work and where they are applied.
- Compare Kruskal’s and Prim’s algorithms in both theory and practice.
- Implement reading/writing of input and output data using JSON files.
- Test algorithm performance on graphs of different sizes.
- Analyze efficiency, scalability, and performance.

---

## 3. Tools and Technologies
- **Java 17**
- **Maven Build System**
- **Gson** library (for JSON parsing)
- **JUnit 5** (for automated testing)
- **GitHub** (for version control and submission)

---

## 4. Project Structure

Assignment3_MST/
│
├── pom.xml
├── input.json
├── output.json
│
├── src/
│ ├── main/java/
│ │ ├── model/
│ │ │ ├── Edge.java
│ │ │ └── Graph.java
│ │ ├── algorithms/
│ │ │ ├── PrimAlgorithm.java
│ │ │ └── KruskalAlgorithm.java
│ │ ├── utils/
│ │ │ └── JsonIO.java
│ │ └── Main.java
│ │
│ └── test/java/
│ └── tests/
│ └── TestMST.java
│
└── README.md
## 5. Algorithms Overview

### 5.1 Kruskal’s Algorithm
Kruskal’s algorithm builds the MST by adding the smallest edges one by one while avoiding cycles.  
It uses a **Union-Find (Disjoint Set Union)** data structure to check whether an edge connects different components.

**Steps:**
1. Sort all edges in ascending order by weight.  
2. Start adding edges to the MST one by one.  
3. If adding an edge forms a cycle, skip it.  
4. Continue until the MST contains `V - 1` edges.

**Time Complexity:** O(E log E)  
**Space Complexity:** O(V + E)

---

### 5.2 Prim’s Algorithm
Prim’s algorithm starts from an arbitrary vertex and grows the MST step by step by choosing the smallest edge that connects the current tree to a new vertex.

**Steps:**
1. Start with a random vertex.  
2. Add the smallest edge connecting a visited vertex to an unvisited one.  
3. Mark the new vertex as visited.  
4. Repeat until all vertices are connected.

**Time Complexity:** O(V²) (basic implementation)  
**Space Complexity:** O(V + E)

---

## 6. Input and Output Format

### Input (`input.json`)
Contains multiple graphs with nodes and weighted edges.

Example:
```json
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D", "E"],
      "edges": [
        {"from": "A", "to": "B", "weight": 4},
        {"from": "B", "to": "C", "weight": 2}
      ]
    }
  ]
}
```
Output (output.json)
Contains MST results for each graph (list of edges and total cost).
```
{
  "1": {
    "mst_edges": [
      {"from": "B", "to": "C", "weight": 2},
      {"from": "A", "to": "B", "weight": 4}
    ],
    "total_cost": 6
  }
}
```
## 7. Testing
Automated tests are included in TestMST.java and check:

Correctness of MST (same total cost for both algorithms).

MST size equals V - 1.

MST contains no cycles.

Execution time is non-negative.

Run tests:
mvn test

Expected output:
BUILD SUCCESS
## 8. How to Build and Run

Build the project
mvn clean compile

Run the program
mvn exec:java -Dexec.mainClass="main.java.Main"

This will read input.json, compute MSTs for all graphs, and save results to output.json
## 9. Results and Analysis
Graph ID	Algorithm	Total Cost	Execution Time (ms)	Operations
1	Kruskal	17	1.23	12
1	Prim	17	1.57	15
2	Kruskal	6	0.96	9
2	Prim	6	1.11	10

Both algorithms produced identical MST costs, but Kruskal’s algorithm performed slightly faster on sparse graphs.
Prim’s algorithm shows more consistent behavior on dense graphs.

## 10. Conclusion
Both Kruskal’s and Prim’s algorithms correctly find the MST for all datasets.

Kruskal’s algorithm is more efficient for sparse graphs, as it processes fewer edges.

Prim’s algorithm is generally better for dense graphs or when using adjacency matrices.
The final results confirmed theoretical expectations, and the MST total cost was identical for both algorithms.
