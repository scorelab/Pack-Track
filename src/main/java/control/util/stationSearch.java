import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
public class stationSearch{
	
	private static Node root=null;
	private static List<Node> stationList = new ArrayList<Node>();
	private static stationSearch instance;
	
	
	private stationSearch(){
		
		
		try{
			   FileInputStream fin = new FileInputStream("station.txt");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   Node s = (Node) ois.readObject();
			   stationList.add(s);
			   ois.close();
	 
			   //return address;
	 
		   }catch(Exception ex){
			   System.out.println("Not input");
			   //return null;
		   } 
		
	}
	
 
 
        //h scores is the stright-line distance from the current city to Bucharest
        public static void main(String[] args){

        	addStation("colombo", 0, null );
        	addStation("gampaha", 50, "colombo");
        	addStation("ragama", 150, "gampaha");
        	addStation("maradana", 100, "colombo");
        	printStation();
        	getDistance("maradana", "ragama");
        	getInstance().printStation();
 
        }
        
        public static stationSearch getInstance(){
        	
        	if(instance==null){
        		instance=new stationSearch();
        		return instance;
        		
        	}
        	else{
        		return instance;
        		
        	}
        	
        }
        
        public static void getDistance(String start, String finish){
        	
        	Node n1=getStation(start);
        	Node n2=getStation(finish);
        	
        	stationNav(n1,n2);
        	 
            List<Node> path = printPath(n2);

                    System.out.println("Path"+ path);
                    System.out.println("Distance "+ n2.distance());        	
                    
        }
        
        public static void printStation(){
        	
        	if(root!=null){
        	for (int i = 0; i < stationList.size(); i++) {
    			Node n = (Node) stationList.get(i);
    			System.out.println(n.value);
    		}
        	}
    			
        }
        
        public static Node getStation(String name){
        	
        	if(root!=null){
        	for (int i = 0; i < stationList.size(); i++) {
    			Node n = (Node) stationList.get(i);
    			//System.out.println(n.value);
    			if(n.value==name){
    				return n;
    				
    			}
    		
    		}}
        	
        	return null;
        	
        	
        }
 
        public static void addStation(String name, int distance, String prev ){
        	
        	Node newStation=new Node(name);
        	
        	if(root==null){
        		
        		stationList.add(newStation);
        		//System.out.println("Done1");
        		root=stationList.get(0);
        		//System.out.println("Done2");
        		
        	}
        	else{
        		//System.out.println("Done3");
	        	Node parent=getStation(prev);
	        	//System.out.println(parent.value);
	        	//System.out.println("Done4");
	        	parent.adjacencies.add(new Edge(newStation, distance));  
	        	newStation.adjacencies.add(new Edge(parent, distance));
	        	stationList.add(newStation);
        	}
        	
        	/*File f = new File("station.txt");
    		try {
    		    if(!f.exists()) f.createNewFile();
    		} catch(IOException e) {
    		}*/
        	
        	try{
    			FileOutputStream fout = new FileOutputStream("station.obj");
    			ObjectOutputStream oos = new ObjectOutputStream(fout);   
    			oos.writeObject(newStation);
    			oos.close();
    			System.out.println("Done");
    	 
    		   }catch(Exception ex){
    			   System.out.println("Not Do");
    			   ex.printStackTrace();
    		   }
        	
        }
        
        public static List<Node> printPath(Node target){
                List<Node> path = new ArrayList<Node>();
        
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }
 
        Collections.reverse(path);
 
        return path;
        }
 
        public static void stationNav(Node source, Node goal){
 
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
 
class Node implements Serializable{
 
        public final String value;
        public double g_scores;
        public final double h_scores=0;
        public double f_scores = 0;
        public List<Edge> adjacencies = new ArrayList<Edge>();
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
 
class Edge implements Serializable{
        public final double cost;
        public final Node target;
 
        public Edge(Node targetNode, double costVal){
                target = targetNode;
                cost = costVal;
        }
}