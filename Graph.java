/*Kristina Saha
 * UNI ks3401
 * Data Structures
 * Graph class */

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Graph class for drawing TPS shortest path using NN and brute force.
 * @author Prof. Blaer, TAs, James Shin (js4785)
 */
public class Graph {

	// Keep a fast index to nodes in the map
	private Map<Integer, Vertex> vertexNames;

	/**
	 * Construct an empty Graph with a map. The map's key is name of a vertex
	 * and the map's value is the vertex object.
	 */
	public Graph() {
		vertexNames = new HashMap<>();
	}

	/**
	 * Adds vertex to graph. Throws IllegalArgumentException if two vertices
	 * with the same name are added.
	 * 
	 * @param v
	 *          (Vertex) vertex to be added to the graph
	 */
	public void addVertex(Vertex v) {
		if (vertexNames.containsKey(v.name))
			throw new IllegalArgumentException("Cannot create new vertex "
					+ "with existing name.");
		vertexNames.put(v.name, v);
	}

	/**
	 * Gets a collection of all the vertices in the graph
	 * 
	 * @return (Collection<Vertex>) collection of all the vertices in graph
	 */
	public Collection<Vertex> getVertices() {
		return vertexNames.values();
	}

	/**
	 * Gets the vertex object with the given name
	 * 
	 * @param name
	 *          (String) name of the vertex object requested
	 * @return (Vertex) vertex object associated with the name
	 */
	public Vertex getVertex(String name) {
		return vertexNames.get(name);
	}

	/**
	 * Adds a directed edge from vertex u to vertex v
	 * 
	 * @param nameU
	 *          (String) name of vertex u
	 * @param nameV
	 *          (String) name of vertex v
	 * @param cost
	 *          (double) cost of the edge between vertex u and v
	 */
	public void addEdge(int nameU, int nameV, Double cost) {
		if (!vertexNames.containsKey(nameU))
			throw new IllegalArgumentException(nameU + 
					" does not exist. Cannot create edge.");
		if (!vertexNames.containsKey(nameV))
			throw new IllegalArgumentException(nameV + 
					" does not exist. Cannot create edge.");
		Vertex sourceVertex = vertexNames.get(nameU);
		Vertex targetVertex = vertexNames.get(nameV);
		Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
		sourceVertex.addEdge(newEdge);
	}

	/**
	 * Adds an undirected edge between vertex u and vertex v by adding a 
	 * directed edge from u to v, then a directed edge from v to u
	 * 
	 * @param name
	 *          (String) name of vertex u
	 * @param name2
	 *          (String) name of vertex v
	 * @param cost
	 *          (double) cost of the edge between vertex u and v
	 */
	public void addUndirectedEdge(int name, int name2, double cost) {
		addEdge(name, name2, cost);
		addEdge(name2, name, cost);
	}


	/**
	 * Computes euclidean distance between two points as described by their
	 * coordinates
	 * 
	 * @param ux
	 *          (double) x coordinate of point u
	 * @param uy
	 *          (double) y coordinate of point u
	 * @param vx
	 *          (double) x coordinate of point v
	 * @param vy
	 *          (double) y coordinate of point v
	 * @return (double) distance between the two points
	 */
	public double computeEuclideanDistance(
			double ux, double uy, double vx, double vy) {
		return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
	}

	/**
	 * Computes euclidean distance between two vertices as described by their
	 * coordinates
	 * 
	 * @param u
	 *          (Vertex) vertex u
	 * @param v
	 *          (Vertex) vertex v
	 * @return (double) distance between two vertices
	 */
	public double computeEuclideanDistance(Vertex u, Vertex v) {
		return computeEuclideanDistance(u.x, u.y, v.x, v.y);
	}

	/**
	 * Calculates the euclidean distance for all edges in the map using the
	 * computeEuclideanCost method.
	 */
	public void computeAllEuclideanDistances() {
		for (Vertex u : getVertices())
			for (Edge uv : u.adjacentEdges) {
				Vertex v = uv.target;
				uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
			}
	}



	// STUDENT CODE STARTS HERE

	/**
	 * Generates random vertices and creates its complete graph.
	 * @param n number of vertices to be included in the graph.
	 */
	public void generateRandomVertices(int n) {
		vertexNames = new HashMap<>(); // reset the vertex hashmap
		Random rand = new Random();
		
		// Create n vertices with random x, y coordinates from 0 to 100 
		// inclusive, starting with index 0 and ending with index n - 1.
		for(int i = 0; i < n; i++)
		{
			int x = rand.nextInt(101);
			int y = rand.nextInt(101);
			addVertex(new Vertex(i, x, y));
		}
		
		// For each pair of vertices, add an undirected edge.
		for(int i = 0; i < vertexNames.size(); i++) // First vertex with...
			for(int j = i + 1; j < vertexNames.size(); j++) // ...every other
				addUndirectedEdge(vertexNames.get(i).name, // Add edge
						vertexNames.get(j).name, 0);

		computeAllEuclideanDistances(); // compute distances
	}

	/**
	 * Returns nearest neighbor path from performing the nearest neighbor
	 * algorithm. Performs algorithm on all n vertices and returns the path
	 * that has the shortest length.
	 * @return List<Edge> which contains nearest neighbor path.
	 */
	public List<Edge> nearestNeighborTsp() {
		double smallestDistance = Double.MAX_VALUE; // Store shortest d here
		List<Edge> shortestPath = null;	// Store the actual path here
		
		// For each vertex, perform nearest neighbor, check its length
		// against current smallest path. If smaller, replace.
		for(Vertex v : getVertices())
		{
			List<Edge> path = nearestNeighborHelper(v); // NN path
			double length = returnPathLength(path); // Path's length
			
			// If smaller than current smallest, replace
			if(length < smallestDistance)
			{
				smallestDistance = length;
				shortestPath = path;
			}
		}
		
		// Return the shortest nearest-neighbor path
		return shortestPath;
	}

	/*
	 * Helper method which performs nearest neighbor on the given vertex
	 * and returns the resulting nearest neighbor path. 
	 * @param v Vertex which nearest neighbor should be performed on
	 * @return nearest neighbor path starting at given vertex v
	 */
	private List<Edge> nearestNeighborHelper(Vertex v)
	{
		/* Find nearest vertex, store it in currentVertex,
		 * and add edge from previous vertex to currentVertex to some 
		 * initially empty list 'path' which will be returned as the nearest 
		 * neighbor path. The 'known' field will let us know that a vertex
		 * hasn't been visited already (since it isn't being used anymore
		 * for its original purpose).
		 */
		Vertex currentVertex = v;
		v.known = true;
		List<Edge> path = new LinkedList<>();
		
		/* General idea here is to get the starting vertex. Look at edges
		 * to all other unknown vertices, find shortest edge. Make the
		 * edge's target vertex known, add it to the paths list, and
		 * change currentVertex to the edge's target. Continue process
		 * with the new currentVertex.
		 * 
		 * We look to add edges until total edges is equal to n - 1. We
		 * can only add the nth edge last, and separately, since we aren't
		 * able to visit vertices again, except for the last edge which
		 * completes the cycle.
		 */
		while(path.size() < vertexNames.size() - 1)
		{
			double shortestLength = Double.MAX_VALUE; // Shortest edge length
			Edge shortestEdge = null;				  // Shortest edge
			
			// Cycle through all adjacent edges whose targets are unknown.
			// If distance is smaller than current smallest, replace length
			// and the edge
			for(Edge e : currentVertex.adjacentEdges)
			{
				if (!e.target.known && e.distance < shortestLength)
				{
					shortestLength = e.distance;
					shortestEdge = e;
				}
			}
			
			// Set known, get next vertex. Add edge to path list.
			shortestEdge.target.known = true;
			path.add(shortestEdge);
			currentVertex = shortestEdge.target;
		}

		// Add last edge which leads to the original vertex and completes
		// the cycle
		for(Edge e : currentVertex.adjacentEdges)
		{
			if(e.target == v)
			{
				path.add(e);
				break;
			}
		}
		
		// Reset the 'known' field for all vertices
		for(Vertex x : getVertices())
			x.known = false;
		return path;
	}

	/*
	 * Returns the given path's length 
	 * @param path the list of edges representing some path
	 * @return the length of that path
	 */
	private double returnPathLength(List<Edge> path)
	{
		double sum = 0.0;
		
		// Add distances of each edge to the sum and return the sum
		for(Edge e : path)
			sum += e.distance;
		return sum;
	}

	/**
	 * Utilizes brute force algorithm to find shortest path for the
	 * Traveling Salesman problem. Utilizes permutations of all possible
	 * paths and just returns the shortest one.
	 * @return List<Edge>, a list of edges representing shortest path
	 */
	public List<Edge> bruteForceTsp() 
	{
		// Store one permutation of vertices into 'array'
		int[] array = new int[vertexNames.size()];
		for(int i = 0; i < array.length; i++)
			array[i] = i;
		
		// Get all permutations of 'array' and store into 'permutations'
		LinkedList<int[]> permutations = new LinkedList<>();
		permute(permutations, array, 0);
		
		/* Find the shortest of all of the permutations.
		 * For all permutations, compute all edge lengths for every pair of
		 * vertices. If total edge length is smaller than current smallest,
		 * replace smallestLength and shortestPermutation which keep track
		 * of the shortest path length and shortest path as an int array.
		 */
		double smallestLength = Double.MAX_VALUE; // Shortest path's length
		int[] shortestPermutation = null;		  // Shortest path
		for(int[] permutation : permutations)
		{
			double totalEdgeCost = 0.0;	// Current path's total cost
			
			// Get pairs of vertices, compute euclidean distance and add
			// to total edge cost. Stop when last two vertices added. 
			// Note to mod by length since the last vertex is paired with
			// the first
			for(int i = 0; i < permutation.length; i++)
				totalEdgeCost += computeEuclideanDistance(
						vertexNames.get(permutation[i]), 
						vertexNames.get(permutation[(i+1) % 
						                permutation.length]));

			// If the total edge cost is less than current smallest, replace
			if (totalEdgeCost < smallestLength)
			{
				smallestLength = totalEdgeCost;
				shortestPermutation = permutation;
			}
		}


		// Now we have the shortest path as an int array, so recreate it
		// as a list of edges. For each vertex, go through adjacent edges
		// and find target vertex, which is the consecutive vertex in the
		// shortestPermutation array. Then add that edge to path and break.
		List<Edge> shortestPath = new LinkedList<>();
		for(int i = 0; i < shortestPermutation.length; i++)
			for(Edge e:vertexNames.get(shortestPermutation[i]).adjacentEdges)
				
				// Look for the next vertex in shortestPermutation within
				// the target vertices of each vertex. When found, add to
				// path and break. Note to mod by length since the last
				// vertex needs to be connected to the first
				if(e.target == vertexNames.get(shortestPermutation[(i+1) % 
				                               shortestPermutation.length]))
				{
					shortestPath.add(e);
					break;
				}

		// Return the shortest path, which is a list of edges.
		return shortestPath;
	}

	/*
	 * Recursively populates given LinkedList with int arrays of permutations
	 * given some array to find the permutations of. 
	 * @param permutations the LinkedList which stores all permutations
	 * @param array the array to permute
	 * @param i the index of which to start permuting
	 */
	private void permute(LinkedList<int[]> permutations, int[] array, int i) 
	{
		/* We want to permute in a tree-like structure. We swap pairs of
		 * vertices and stop swapping before index i. Index i is incremented
		 * for every pair of swaps, which means every permutation is hit
		 * exactly once. The base case is reached when i has reached the
		 * last index, or array.length - 1. This means that we have no more
		 * numbers to permute, so we just add a clone of that integer array
		 * to the list of permutations and cut off the recursion. 
		 */
		if (array.length - 1 == i) 
		{
			permutations.add(array.clone());
			return;
		}
		
		// For each pair we swap items in i and j and permute everything
		// after index i+1. We swap i and j back, since the array is
		// mutable. Note we are adding clones to 'permutations' list.
		for (int j = i; j < array.length; j++) 
		{
			swap(array, i, j);
			permute(permutations, array, i+1);
			swap(array, i, j);
		}
	}

	/*
	 * Swaps two items in an integer array.
	 * @param array the array whose items will be swapped
	 * @param x first index of item in array to swap
	 * @param y second index of item in array to swap
	 */
	private void swap(int[] array, int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	// STUDENT CODE ENDS HERE



	/**
	 * Prints out the adjacency list of the graph for debugging
	 */
	public void printAdjacencyList() {
		for (int u : vertexNames.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(u);
			sb.append(" -> [ ");
			for (Edge e : vertexNames.get(u).adjacentEdges) {
				sb.append(e.target.name);
				sb.append("(");
				sb.append(e.distance);
				sb.append(") ");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
}