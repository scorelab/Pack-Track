package control.util;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.managers.StationManager;
import model.models.Dist;

public class StationSearch {

	private static List<Node> stationList = new ArrayList<Node>();
	private static StationSearch instance;

	private StationSearch() {

		List<Dist> br = null;
		StationManager sm = new StationManager();

		br = sm.getDistList();

		for (Dist d : br) {
			String[] parameter = d.getDist().split(" ");

			createStation(parameter[1], parameter[0],
					Double.parseDouble(parameter[2]));

		}

	}

	// h scores is the stright-line distance from the current city to Bucharest

	public static int getSize() {
		return stationList.size();
	}

	public static StationSearch getInstance() {

		if (instance == null) {
			instance = new StationSearch();
			return instance;

		} else {
			return instance;

		}

	}

	public static float getDistance(String start, String finish) {

		Node n1 = getStation(start);
		Node n2 = getStation(finish);

		if (n1 == null) {
			return 0;
		} else if (n2 == null) {
			return 0;
		} else {
			stationNav(n1, n2);

			List<Node> path = printPath(n2);

			float dist = (float) n2.distance();

			if (stationList.size() != 0) {
				for (int i = 0; i < stationList.size(); i++) {
					Node n = (Node) stationList.get(i);
					n.f_scores = 0;
					n.g_scores = 0;
					n.parent = null;

					// n.h_scores=0;

				}
			}

			return dist;

		}

	}

	public static void printStation() {

		if (stationList.size() != 0) {
			for (int i = 0; i < stationList.size(); i++) {
				Node n = (Node) stationList.get(i);

			}
		}

	}

	public static Node getStation(String name) {

		if (stationList.size() != 0) {
			for (int i = 0; i < stationList.size(); i++) {
				Node n = stationList.get(i);

				if (n.value.equals(name)) {

					return stationList.get(i);
				}
			}
		}

		return null;

	}

	public static void addStation(String name, String prev, int distance) {

		if (stationList.size() == 0) {

			Node newStation = new Node(name);

			Node prevStation = new Node(prev);
			stationList.add(newStation);

			stationList.add(prevStation);
			newStation = getStation(name);
			prevStation = getStation(prev);
			prevStation.adjacencies.add(new Edge(newStation, distance));
			newStation.adjacencies.add(new Edge(prevStation, distance));

		} else {

			Node newStation = new Node(name);
			Node parent = getStation(prev);
			if (parent == null) {
				parent = new Node(prev);
				parent.adjacencies.add(new Edge(newStation, distance));
				newStation.adjacencies.add(new Edge(parent, distance));
				stationList.add(newStation);
				stationList.add(parent);
			} else {
				parent.adjacencies.add(new Edge(newStation, distance));
				newStation.adjacencies.add(new Edge(parent, distance));
				stationList.add(newStation);
			}

		}

		try (FileWriter fw = new FileWriter("station.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(name + " " + prev + " " + Integer.toString(distance));
		} catch (IOException e) {

		}

	}

	public static void createStation(String name, String prev, double distance) {

		// same as add station method
		if (stationList.size() == 0) {

			Node newStation = new Node(name);

			Node prevStation = new Node(prev);
			stationList.add(newStation);

			stationList.add(prevStation);
			newStation = getStation(name);
			prevStation = getStation(prev);
			prevStation.adjacencies.add(new Edge(newStation, distance));
			newStation.adjacencies.add(new Edge(prevStation, distance));
		} else {

			Node newStation = new Node(name);
			Node parent = getStation(prev);
			if (parent == null) {

				parent = new Node(prev);
				parent.adjacencies.add(new Edge(newStation, distance));
				newStation.adjacencies.add(new Edge(parent, distance));
				stationList.add(newStation);
				stationList.add(parent);
			} else {
				parent.adjacencies.add(new Edge(newStation, distance));
				newStation.adjacencies.add(new Edge(parent, distance));
				stationList.add(newStation);
			}
		}
	}

	public static List<Node> printPath(Node target) {
		List<Node> path = new ArrayList<Node>();

		for (Node node = target; node != null; node = node.parent) {
			path.add(node);
		}

		Collections.reverse(path);

		return path;
	}

	public static void stationNav(Node source, Node goal) {

		Set<Node> explored = new HashSet<Node>();

		PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
				new Comparator<Node>() {
					// override compare method
					public int compare(Node i, Node j) {
						if (i.f_scores > j.f_scores) {
							return 1;
						}

						else if (i.f_scores < j.f_scores) {
							return -1;
						}

						else {
							return 0;
						}
					}

				});

		// cost from start
		source.g_scores = 0;

		queue.add(source);

		boolean found = false;

		while ((!queue.isEmpty()) && (!found)) {

			// the node in having the lowest f_score value
			Node current = queue.poll();

			explored.add(current);

			// goal found
			if (current.value.equals(goal.value)) {
				found = true;
			}

			// check every child of current node
			for (Edge e : current.adjacencies) {
				Node child = e.target;
				double cost = e.cost;
				double temp_g_scores = current.g_scores + cost;
				double temp_f_scores = temp_g_scores + child.h_scores;

				/*
				 * if child node has been evaluated and the newer f_score is
				 * higher, skip
				 */

				if ((explored.contains(child))
						&& (temp_f_scores >= child.f_scores)) {
					continue;
				}

				/*
				 * else if child node is not in queue or newer f_score is lower
				 */

				else if ((!queue.contains(child))
						|| (temp_f_scores < child.f_scores)) {

					child.parent = current;
					child.g_scores = temp_g_scores;
					child.f_scores = temp_f_scores;

					if (queue.contains(child)) {
						queue.remove(child);
					}

					queue.add(child);

				}

			}

		}

	}

}

class Node {

	public final String value;
	public double g_scores;
	public final double h_scores = 0;
	public double f_scores = 0;
	public List<Edge> adjacencies = new ArrayList<Edge>();
	public Node parent;

	public Node(String val) {
		value = val;
	}

	@Override
	public String toString() {
		return value;
	}

	public double distance() {
		double val = g_scores;
		return val;
	}

}

class Edge {
	public final double cost;
	public final Node target;

	public Edge(Node targetNode, double costVal) {
		target = targetNode;
		cost = costVal;
	}
}