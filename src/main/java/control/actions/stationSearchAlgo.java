package control.actions;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
 
public class stationSearchAlgo{
 
 
        //h scores is the stright-line distance from the current city to Bucharest
        public static void main(String[] args){
 
                //initialize the graph base on the Romania map
                Node n1 = new Node("colombo");
                Node n2 = new Node("maradana");
                Node n3 = new Node("galle");
                Node n4 = new Node("ragama");
                Node n5 = new Node("polgahawela");
                Node n6 = new Node("negambo");
                Node n7 = new Node("pera");
                Node n8 = new Node("maho");
                Node n9 = new Node("kandy");
                Node n10 = new Node("badulla");
                //Node n11 = new Node("apura",0);
                //Node n12 = new Node("galoya",0);
                //Node n13 = new Node("trinco",0);
                //Node n14 = new Node("batclow",77);
 
                //initialize the edges
 
                //colombo
                n1.adjacencies = new Edge[]{
                        new Edge(n2,10),
                        new Edge(n3,300)
                };
                 
                 //maradana
                n2.adjacencies = new Edge[]{
                        new Edge(n1,10),
                        new Edge(n4,50)
                };
                 
 
                 //galle
                n3.adjacencies = new Edge[]{
                        new Edge(n1,300)
                };
                 
                 //ragama
                n4.adjacencies = new Edge[]{
                        new Edge(n2,50),
                        new Edge(n5,200),
                        new Edge(n6,100)
                };
                 
 
                 //polgahawela
                n5.adjacencies = new Edge[]{
                        new Edge(n4,200),
                        new Edge(n7,250),
                        new Edge(n8,120),
 
                        //178
                        //new Edge(n13,211)
                };
                 
                 //negambo
                n6.adjacencies = new Edge[]{
                        new Edge(n4,100)
                        
                };
                 
                 //pera
                n7.adjacencies = new Edge[]{
                        new Edge(n9,250),
                        new Edge(n10,150)
                        
                };
                 
                 //maho
                n8.adjacencies = new Edge[]{
                        new Edge(n5,120),
                        //new Edge(n12,50),
                        //new Edge(n11,400),
                };
                 
                 //kandy
                n9.adjacencies = new Edge[]{
                        new Edge(n7,250),
                };
 
                 //badulla
                n10.adjacencies = new Edge[]{
                        new Edge(n7,150)
                  
                };
                 
 
                stationSearch(n8,n9);
 
                List<Node> path = printPath(n9);
 
                        System.out.println("Path"+ path);
                        System.out.println("Distance "+ n9.distance());
 
 
        }
 
        public static List<Node> printPath(Node target){
                List<Node> path = new ArrayList<Node>();
        
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }
 
        Collections.reverse(path);
 
        return path;
        }
 
        public static void stationSearch(Node source, Node goal){
 
                Set<Node> explored = new HashSet<Node>();
 
                PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
                        new Comparator<Node>(){
                                 //override compare method
                 public int compare(Node i, Node j){
                    if(i.f_scores > j.f_scores){
                        return 1;
                    }
 
                    else if (i.f_scores < j.f_scores){
                        return -1;
                    }
 
                    else{
                        return 0;
                    }
                 }
 
                        }
                        );
 
                //cost from start
                source.g_scores = 0;
 
                queue.add(source);
 
                boolean found = false;
 
                while((!queue.isEmpty())&&(!found)){
 
                        //the node in having the lowest f_score value
                        Node current = queue.poll();
 
                        explored.add(current);
 
                        //goal found
                        if(current.value.equals(goal.value)){
                                found = true;
                        }
 
                        //check every child of current node
                        for(Edge e : current.adjacencies){
                                Node child = e.target;
                                double cost = e.cost;
                                double temp_g_scores = current.g_scores + cost;
                                double temp_f_scores = temp_g_scores + child.h_scores;
 
 
                                /*if child node has been evaluated and 
                                the newer f_score is higher, skip*/
                                
                                if((explored.contains(child)) && 
                                        (temp_f_scores >= child.f_scores)){
                                        continue;
                                }
 
                                /*else if child node is not in queue or 
                                newer f_score is lower*/
                                
                                else if((!queue.contains(child)) || 
                                        (temp_f_scores < child.f_scores)){
 
                                        child.parent = current;
                                        child.g_scores = temp_g_scores;
                                        child.f_scores = temp_f_scores;
 
                                        if(queue.contains(child)){
                                                queue.remove(child);
                                        }
 
                                        queue.add(child);
 
                                }
 
                        }
 
                }
 
        }
        
}
 
class Node{
 
        public final String value;
        public double g_scores;
        public final double h_scores=0;
        public double f_scores = 0;
        public Edge[] adjacencies;
        public Node parent;
 
        public Node(String val){
                value = val;
        }
 
        public String toString(){
                return value;
        }
        
        public String distance(){
        	String val = Double.toString(g_scores);
                return val;
        }
        
        
 
}
 
class Edge{
        public final double cost;
        public final Node target;
 
        public Edge(Node targetNode, double costVal){
                target = targetNode;
                cost = costVal;
        }
}