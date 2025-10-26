# Assignment 3 — Optimization of a City Transportation Network (Minimum Spanning Tree)
1. Introduction
This project was completed as part of the Data Structures and Algorithms course.
Its main goal is to apply Prim’s and Kruskal’s algorithms to find a Minimum Spanning Tree (MST) for a city’s transportation network.

The MST connects all districts (vertices) with the lowest possible total road construction cost and no cycles.

Implemented algorithms:

Kruskal’s Algorithm

Prim’s Algorithm

Both algorithms read data from input.json, process them, and save the results to output.json.

## 2. Objective
The main objectives of the assignment are:

Implement and understand two MST algorithms — Prim’s and Kruskal’s.

Use object-oriented design with custom Graph and Edge classes.

Compare algorithm performance in terms of execution time and operation count.

Analyze algorithm efficiency across graphs of different sizes and densities.

Automate tests and record the results in structured JSON format.

## 3. Tools and Technologies
Java 17

Maven Build System

Gson (Google JSON library) — for reading/writing JSON

JUnit 5 — for automated testing

GitHub — version control and submission platform

## 4. Project Structure

Assignment3_MST/
│
├── pom.xml
├── input.json
├── output.json
│
├── src/
│   ├── main/java/
│   │   ├── model/
│   │   │   ├── Edge.java
│   │   │   └── Graph.java
│   │   ├── algorithms/
│   │   │   ├── PrimAlgorithm.java
│   │   │   └── KruskalAlgorithm.java
│   │   ├── utils/
│   │   │   └── JsonIO.java
│   │   └── Main.java
│   │
│   └── test/java/
│       └── tests/
│           └── TestMST.java
│
└── README.md

## 5. Graph Visualization
To illustrate the dataset, here’s an example of one of the test graphs used in input.json:


Each vertex represents a city district, and each edge represents a possible road with its construction cost as a weight.

## 6. Algorithm Overview
6.1 Kruskal’s Algorithm
Kruskal’s algorithm sorts all edges by their weights and adds them to the MST one by one, avoiding cycles using a Disjoint Set (Union-Find) structure.

Steps:

Sort edges in ascending order by weight.

Add edges sequentially if they connect disjoint components.

Stop when MST has V - 1 edges.

Complexity:

Time: O(E log E)

Space: O(V + E)

6.2 Prim’s Algorithm
Prim’s algorithm grows the MST from a single starting vertex, repeatedly adding the smallest edge that connects a new vertex.

Steps:

Start from an arbitrary vertex.

Choose the smallest edge to a new vertex.

Repeat until all vertices are connected.

Complexity:

Time: O(V²) (basic version)

Space: O(V + E)

## 7. Input and Output Format
Input (input.json)
```
{
  "graphs": [
    {
      "id": 1,
      "nodes": ["A", "B", "C", "D", "E"],
      "edges": [
        {"from": "A", "to": "B", "weight": 4},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "A", "to": "C", "weight": 3}
      ]
    }
  ]
}
```
Output (output.json)
```
{
  "1": {
    "prim": {
      "mst_edges": [
        {"from": "A", "to": "C", "weight": 3},
        {"from": "B", "to": "C", "weight": 2},
        {"from": "D", "to": "B", "weight": 5},
        {"from": "E", "to": "D", "weight": 6}
      ],
      "total_cost": 16
    },
    "kruskal": {
      "mst_edges": [
        {"from": "B", "to": "C", "weight": 2},
        {"from": "A", "to": "C", "weight": 3},
        {"from": "D", "to": "B", "weight": 5},
        {"from": "E", "to": "D", "weight": 6}
      ],
      "total_cost": 16
    }
  }
}
```
## 8. Automated Testing
The tests in TestMST.java check:

MST total cost equality between algorithms

Correct number of edges (V - 1)

No cycles in MST

Non-negative execution time

Deterministic results on repeated runs

Run tests:
```
mvn test
```
Expected output:

nginx

BUILD SUCCESS
9. Build and Run Instructions
Build the project:
```
mvn clean compile
```
Run the program:
```
mvn exec:java -Dexec.mainClass="main.java.Main"
This will read input.json, compute MSTs for all graphs, and save results to output.json.
```
## 10. Results and Analysis
Graph ID	Algorithm	Total Cost	Execution Time (ms)	Operations
1	Kruskal	16	1.12	10
1	Prim	16	1.45	13
2	Kruskal	6	0.89	8
2	Prim	6	1.20	10

Observation:
Both algorithms produced identical MST costs.
Kruskal’s algorithm performed slightly faster on sparse graphs, while Prim’s algorithm was more stable on dense ones.

## 11. Bonus: Object-Oriented Graph Design (+10%)
For the bonus part, the graph structure was implemented using two custom classes:

Graph.java — stores vertices and edges

Edge.java — represents weighted connections between vertices

Both algorithms directly use the Graph object instead of raw arrays or maps.
This design improves code readability, modularity, and reusability.
<img width="1176" height="790" alt="image" src="https://github.com/user-attachments/assets/bc70071f-53d0-4d61-86d4-338e02fce927" />

## 12. Conclusion
Both Prim’s and Kruskal’s algorithms successfully find the MST for all test cases.

Kruskal’s is preferable for sparse graphs due to fewer edges.

Prim’s is more effective for dense graphs or adjacency matrix representations.

The results fully align with theoretical expectations.

The project demonstrates understanding of graph theory, algorithm design, and OOP in Java.
