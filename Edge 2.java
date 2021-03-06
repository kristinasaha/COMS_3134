/*Kristina Saha
 * UNI ks3401
 * Data Structures
 * Edge class */

public class Edge {

  public double distance;
  public Vertex source;
  public Vertex target;

  public Edge(Vertex vertex1, Vertex vertex2, double weight) {
    source = vertex1;
    target = vertex2;
    this.distance = weight;
  }

  public String toString() {
    return source + " - " + target;
  }
}