package utils;

import com.google.gson.*;
import model.Edge;
import model.Graph;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonIO {

    public static Graph readGraphFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray graphs = root.getAsJsonArray("graphs");

            if (graphs == null || graphs.size() == 0) {
                System.out.println("⚠️ No graphs found in JSON!");
                return null;
            }

            // Берём первый граф для примера
            JsonObject g = graphs.get(0).getAsJsonObject();
            JsonArray nodes = g.getAsJsonArray("nodes");
            JsonArray edges = g.getAsJsonArray("edges");

            List<String> vertices = new ArrayList<>();
            for (JsonElement node : nodes) {
                vertices.add(node.getAsString());
            }

            List<Edge> edgeList = new ArrayList<>();
            for (JsonElement e : edges) {
                JsonObject obj = e.getAsJsonObject();
                edgeList.add(new Edge(
                        obj.get("from").getAsString(),
                        obj.get("to").getAsString(),
                        obj.get("weight").getAsInt()
                ));
            }

            return new Graph(vertices, edgeList);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeResultToJson(String filePath, Map<String, Object> data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
            System.out.println("✅ Results written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
