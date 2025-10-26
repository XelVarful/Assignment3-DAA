# Assignment 3 — Minimum Spanning Tree (MST)

## 1. Introduction
This project is part of the Data Structures and Algorithms course.  
The main goal is to implement algorithms that find the **Minimum Spanning Tree (MST)** in a weighted undirected graph.  
The MST connects all vertices in the graph with the minimum possible total edge weight and without forming any cycles.

In this assignment, two classical MST algorithms are implemented:
- **Kruskal’s Algorithm**
- **Prim’s Algorithm**

Both algorithms are tested using example graphs provided in `input.json`, and the resulting MSTs are saved in `output.json`.

---

## 2. Objective
The purpose of this project is to:
- Practice working with graphs and edge lists.
- Understand and compare two MST algorithms.
- Work with file input/output in JSON format.
- Organize a project structure using **Maven**.
- Demonstrate correct use of version control and documentation in GitHub.

---

## 3. Tools and Technologies
- **Java 17**
- **Maven Build System**
- **Gson** library for reading and writing JSON files
- **JUnit 5** for testing
- **GitHub** for version control and submission

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

yaml
Копировать код

---

## 5. Algorithms

### 5.1 Kruskal’s Algorithm
Kruskal’s algorithm sorts all edges in ascending order by weight and adds them one by one to the MST if they do not form a cycle.  
It uses a **Union-Find (Disjoint Set Union)** structure to check whether adding an edge would create a cycle.

**Steps:**
1. Sort all edges by weight.
2. Initialize each vertex as its own set.
3. For each edge, if it connects two different sets, add it to the MST and merge the sets.
4. Repeat until all vertices are connected.

**Time Complexity:** O(E log E)  
**Space Complexity:** O(V + E)

---

### 5.2 Prim’s Algorithm
Prim’s algorithm starts from an arbitrary vertex and grows the MST by repeatedly adding the smallest edge that connects a visited vertex to an unvisited one.

**Steps:**
1. Choose a random starting vertex.
2. Add the smallest edge that connects a visited node to an unvisited one.
3. Mark the connected vertex as visited.
4. Repeat until all vertices are visited.

**Time Complexity:** O(V²)  
(Optimized version with priority queue: O(E log V))  
**Space Complexity:** O(V + E)

---

## 6. Input and Output Format

### Input (`input.json`)
The file contains multiple graphs with their nodes and weighted edges.

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
Output (output.json)
The result contains the MST edges for each graph.

Example:

json
Копировать код
{
  "1": [
    {"from": "B", "to": "C", "weight": 2},
    {"from": "A", "to": "B", "weight": 4}
  ]
}
7. How to Build and Run
Build the project:
bash
Копировать код
mvn clean compile
Run the program:
bash
Копировать код
mvn exec:java -Dexec.mainClass="main.java.Main"
The program will read input.json, process all graphs, and write the results to output.json.

8. Testing
JUnit tests are included in the TestMST.java file.
The tests verify that both Kruskal’s and Prim’s algorithms return correct MSTs for small example graphs.

To run the tests:

bash
Копировать код
mvn test
Expected output:

nginx
Копировать код
BUILD SUCCESS
9. Results and Analysis
Both algorithms produce the same MSTs for all tested graphs.
Kruskal’s algorithm is more efficient for sparse graphs because it focuses on edges.
Prim’s algorithm works better for dense graphs since it grows the MST from a single starting node.

The results are saved automatically in output.json after running the program.

10. Conclusion
This project demonstrated how to:

Implement and compare Kruskal’s and Prim’s MST algorithms.

Work with JSON input/output in Java.

Use Maven for project management.

Apply testing and documentation standards.

Maintain code in a structured and organized format for submission.

The project fulfills all requirements of the assignment.
