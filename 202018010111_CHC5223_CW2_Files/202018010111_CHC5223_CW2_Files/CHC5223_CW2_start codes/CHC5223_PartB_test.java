package CHC5223;

import java.io.IOException;

public class CHC5223_PartB_test {

 public static void main(String[] args) throws IOException {
     AdjacencyMatrix martirx = new AdjacencyMatrix(256);
     martirx.readFile("graphInfo.txt");
     martirx.printStations();
     martirx.printAdjacencyMatrix();
     System.out.println("The sequence Nodes of  BFT:" + martirx.breadthFirstTraversal(5).toString());
     System.out.println("The sequence Nodes of  DFT:" +martirx.depthFirstTraversal(5));
     System.out.println(martirx.dijkstra(3,6));

 }}
