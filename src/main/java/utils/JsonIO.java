package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import model.Edge;
import model.Graph;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class JsonIO {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Graph> readGraphs(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            Type graphListType = new TypeToken<List<Graph>>(){}.getType();
            return gson.fromJson(jsonObject.get("graphs"), graphListType);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void writeResults(String filename, Map<Integer, List<Edge>> results) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(results, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
