package com.io.Java11.dev.code.JourneyPlanner.JP2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JourneyPlanner {

    private static final String FILE_NAME = "/Users/ashwin/Downloads/Ashwin_Technical/Github-Ashwin/Java-Hands-On/dev/code/JourneyPlanner/StationsAndLines.tsv";

    /**
     * The main entry point of the program.
     * Reads the station connections from a TSV file, and finds all possible routes from start to destination
     * and prints the results.
     *
     * @param args The command-line arguments, which must be exactly two: the start and destination stations.
     */
    public static void main(String[] args) {
        // Check if exactly two arguments are provided (start and destination stations)
        if (args.length != 2) {
            System.out.println("Usage: java JourneyPlanner <startStation> <destinationStation>");
            return;
        }

        // Assign input arguments to respective variables
        String startStation = args[0];
        String destinationStation = args[1];

        try {
            // Step 1: Parse the station connections from the TSV file to build the graph
            Map<String, Set<String>> graph = buildStationGraph();

            // Debugging: Print the graph structure to verify correctness
            debugGraph(graph);

            System.out.println(" ");

            // Step 2: Find all possible routes from start to destination using depth-limited DFS
            List<List<String>> allRoutes = findRoutes(graph, startStation, destinationStation);

            // Debugging: Print all the found routes to verify the search results
            debugRoutes(allRoutes);
            System.out.println(" ");
            // Total count of valid routes
            System.out.println("Total valid routes: " + allRoutes.size());

        } catch (IOException e) {
            // Handle any IOExceptions thrown during file reading
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Builds a graph representation of the station connections from a TSV file.
     * <p>
     * Each line in the file should represent a connection between two stations.
     * The graph is bidirectional, meaning if station1 is connected to station2,
     * then station2 is also connected to station1. Each station is a node in the
     * graph, and the connections are the edges.
     *
     * @return A map where each key is a station name and the value is a set of
     *         connected station names.
     * @throws IOException If an I/O error occurs reading from the file.
     */
    private static Map<String, Set<String>> buildStationGraph() throws IOException {

        // Initialize a map to represent the graph where each station maps to a set of connected stations
        Map<String, Set<String>> graph = new HashMap<>();

        // Use a BufferedReader to read the TSV file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(JourneyPlanner.FILE_NAME))) {
            String line; // Variable to hold each line read from the file
            while ((line = reader.readLine()) != null) { // Read until the end of the file
                // Split the line by tab characters to extract station names
                String[] parts = line.split("\t");
                if (parts.length >= 3) { // Ensure that the line has enough data
                    String station1 = parts[0].trim(); // First station name
                    String station2 = parts[1].trim(); // Second station name

                    // Establish a connection from station1 to station2 in the graph
                    graph.computeIfAbsent(station1, k -> new HashSet<>()).add(station2);

                    // Establish a connection from station2 to station1 (bidirectional)
                    graph.computeIfAbsent(station2, k -> new HashSet<>()).add(station1);
                }
            }
        }
        // Return the fully constructed graph
        return graph;
    }

    /**
     * Finds all possible routes in a graph from the start station to the destination station
     * by performing a depth-first search.
     *
     * @param graph       the graph of stations
     * @param start       the start station
     * @param destination the destination station
     * @return a list of lists of strings, where each list represents a route
     *         from the start station to the destination station
     */
    private static List<List<String>> findRoutes(Map<String, Set<String>> graph, String start, String destination) {
        List<List<String>> routes = new ArrayList<>();
        Stack<String> path = new Stack<>();
        Set<String> visited = new HashSet<>();
        dfs(graph, start, destination, path, visited, routes, 20);
        return routes;
    }


    /**
     * Performs a depth-first search on a graph, starting from the given current station, to find all
     * possible routes to the destination station. The search stops when the maximum depth is exceeded.
     *
     * @param graph       the graph of stations
     * @param current     the current station
     * @param destination the destination station
     * @param path        the current path of stations
     * @param visited     a set of stations that have been visited
     * @param routes      a list of lists of strings, where each list represents a route
     *                   from the start station to the destination station
     * @param maxDepth    the maximum depth of the search
     */
    private static void dfs(Map<String, Set<String>> graph, String current, String destination,
                            Stack<String> path, Set<String> visited, List<List<String>> routes, int maxDepth) {
        // Check if the current path length has exceeded the maximum allowed depth
        // If yes, terminate this path search and backtrack
        if (path.size() > maxDepth) return;

        // Add the current station to the path and mark it as visited
        path.push(current);
        visited.add(current);

        // If the current station is the destination, the path is complete
        // Add a copy of the current path to the list of valid routes
        if (current.equals(destination)) {
            routes.add(new ArrayList<>(path));
        } else {
            // Iterate over all neighboring stations of the current station
            // Perform a depth-first search from each neighbor if it hasn't been visited
            for (String neighbor : graph.getOrDefault(current, Collections.emptySet())) {
                if (!visited.contains(neighbor)) {
                    dfs(graph, neighbor, destination, path, visited, routes, maxDepth);
                }
            }
        }

        // Backtrack by removing the current station from the path
        // and marking it as unvisited, allowing other paths to traverse it
        path.pop();
        visited.remove(current);
    }

    /**
     * Prints the structure of the station graph for debugging purposes.
     *
     * @param graph The map representing the station graph, where each key is a station name
     *              and the value is a set of connected station names.
     */
    private static void debugGraph(Map<String, Set<String>> graph) {
        System.out.println("Station graph:");
        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }


    /**
     * Debugging: Print all routes found.
     *
     * @param routes the list of routes found
     */
    private static void debugRoutes(List<List<String>> routes) {
        System.out.println("All routes found:");
        // Print each route as a list of stations
        for (List<String> route : routes) {
          System.out.println(route);
        }
    }
}

