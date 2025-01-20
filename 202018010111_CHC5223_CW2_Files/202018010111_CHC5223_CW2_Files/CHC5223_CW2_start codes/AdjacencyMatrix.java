package CHC5223;

import java.io.*;
import java.util.*;

public class AdjacencyMatrix {
    final double NO_LINK = Double.MAX_VALUE;
    int numStations; // 0 <= numStations <= capacity
    double distance[][];

    // List of objects of class StationInfo held in an array
    StationInfo[] stationInfos;

    public AdjacencyMatrix(int capacity) {
        this.numStations = 0;
        distance = new double[capacity][capacity];
        stationInfos = new StationInfo[capacity];

        // Initialize all distances to NO_LINK
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                distance[i][j] = NO_LINK;
            }
        }
    }


    public void addStation() {
        if (numStations >= distance.length) throw new IllegalStateException("Capacity reached");
        numStations++;
        System.out.println("Station added. Total stations: " + numStations); // Add this line
    }

    public void addLink(int station1, int station2, double distance) {
        if (station1 < 0 || station2 < 0 || station1 >= numStations || station2 >= numStations)
            throw new IllegalArgumentException("Invalid station number");

        this.distance[station1][station2] = distance;
        this.distance[station2][station1] = distance;
    }


    public void readFile(String filename) throws IOException {
        Map<String, Integer> stationIndices = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(" ");
            if (parts.length < 3) {
                throw new IllegalArgumentException("Invalid line: " + line);
            }

            String type = parts[0];


            if (type.equals("station")) {
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid line for station: " + line);
                }
                String name = parts[1];
                int x = Integer.parseInt(parts[2]);
                int y = Integer.parseInt(parts[3]);
                StationInfo station = new StationInfo(name, x, y);
                addStation();
                stationInfos[numStations - 1] = station;
                stationIndices.put(name, numStations - 1);
                System.out.println("Station added to array: " + station.getName());
            } else if (type.equals("link")) {
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid line for link: " + line);
                }
                String station1Name = parts[1];
                String station2Name = parts[2];
                double dist = Double.parseDouble(parts[3]);

                Integer station1Index = stationIndices.get(station1Name);
                Integer station2Index = stationIndices.get(station2Name);

                if (station1Index == null || station2Index == null) {
                    throw new IllegalArgumentException("Link references unknown station: " + line);
                }

                addLink(station1Index, station2Index, dist);
            } else {
                throw new IllegalArgumentException("Unknown type: " + type);
            }
        }

        reader.close();
    }


    public void printStations() {
        System.out.println("Stations:");
        for (int i = 0; i < numStations; i++) {
            StationInfo station = stationInfos[i];
            System.out.println("Name: " + station.getName() + ", X Position: " + station.getxPos() + ", Y Position: " + station.getyPos());
        }
    }

    public void printAdjacencyMatrix() {
        System.out.println("\nAdjacency Matrix:");
        System.out.print("     ");
        for (int i = 0; i < numStations; i++) {
            System.out.printf("%-9d", i);
        }
        System.out.println();
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < (numStations + 1) * 9; i++) {
            separator.append('-');
        }
        System.out.println(separator.toString());

        for (int i = 0; i < numStations; i++) {
            System.out.printf("%-4d| ", i);
            for (int j = 0; j < numStations; j++) {
                if (distance[i][j] == NO_LINK) {
                    System.out.print("NO LINK  ");
                } else {
                    System.out.printf("%.2f   ", distance[i][j]);
                }
            }
            System.out.println("\n");
        }
    }


    public List<StationInfo> breadthFirstTraversal(int startStation) {
        Queue<Integer> Q = new LinkedList<>();
        List<StationInfo> L = new ArrayList<>();

        Q.add(startStation);

        while (!Q.isEmpty()) {
            int S = Q.poll();

            if (!L.contains(stationInfos[S])) {
                L.add(stationInfos[S]);
                for (int S2 = 0; S2 < numStations; S2++) {
                    if (distance[S][S2] != NO_LINK && !L.contains(stationInfos[S2])) {
                        Q.add(S2);
                    }
                }
            }
        }

        return L;
    }


    public List<StationInfo> depthFirstTraversal(int startStation) {
        Stack<Integer> S = new Stack<>();
        List<StationInfo> L = new ArrayList<>();
        S.push(startStation);

        while (!S.isEmpty()) {
            int T = S.pop();
            if (!L.contains(stationInfos[T])) {
                L.add(stationInfos[T]);


                for (int T2 = 0; T2 < numStations; T2++) {
                    if (distance[T][T2] != NO_LINK && !L.contains(stationInfos[T2])) {
                        S.push(T2);
                    }
                }
            }
        }

        return L;
    }

    public double dijkstra(int start, int end) {
        assert 0 <= start && start < numStations : "start out of range!";
        assert 0 <= end && end < numStations : "end out of range!";

        boolean[] closed = new boolean[numStations];
        boolean[] open = new boolean[numStations];
        double[] g_value = new double[numStations];
        int[] previous = new int[numStations];

        for (int i = 0; i < numStations; i++) {
            closed[i] = false;
            open[i] = true;
            g_value[i] = NO_LINK;
            previous[i] = -1;
        }

        g_value[start] = 0;

        int Counter = 0;
        while (open[end]) {
            Counter++;

            double lowest_g = NO_LINK;
            int x = -1;
            for (int i = 0; i < numStations; i++) {
                if (open[i] && (x == -1 || g_value[i] < lowest_g)) {
                    x = i;
                    lowest_g = g_value[i];
                }
            }

            assert x != -1 : "Lowest g value error";

            open[x] = false;

            if (x != end) {
                for (int i = 0; i < numStations; i++) {
                    if (open[i] && distance[x][i] != NO_LINK) {
                        double new_g = g_value[x] + distance[x][i];
                        if (new_g < g_value[i]) {
                            g_value[i] = new_g;
                            previous[i] = x;
                        }
                    }
                }
            }
        }

        System.out.println("Iteration Count: " + Counter);

        if (previous[end] != -1) {
            System.out.print("Shortest path: ");
            List<Integer> path = new ArrayList<>();
            for (int node = end; node != -1; node = previous[node]) {
                path.add(node);
            }
            Collections.reverse(path);
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.print(  " the distance between them is: ");
        }

        return g_value[end];
    }}




