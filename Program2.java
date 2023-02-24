
/*
 * Name: <Olivia Parker>
 * EID: <osp257>
 */

// Implement your algorithms here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;

public class Program2 {
    private ArrayList<City> cities;  // this is a list of all Cities, populated by Driver class
    private Heap minHeap;

    // additional constructor fields may be added, but don't delete or modify anything already here
    public Program2(int numCities) {
        minHeap = new Heap();
        cities = new ArrayList<City>();
    }

    /**
     * findMinimumRouteDistance(City start, City dest)
     *
     * @param start - the starting City.
     * @param dest  - the end (destination) City.
     * @return the minimum distance possible to get from start to dest.
     * Assume the given graph is always connected.
     */
    public int findMinimumRouteDistance(City start, City dest) {
    	int minLength=0;
    	ArrayList<City> used=new ArrayList<City>();
    	int numcities=cities.size()-1;
    	City beginning= start;
    	used.add(beginning);
    	for(City i : beginning.getNeighbors()) {//puts all neighbors of city zero in heap
    		i.setMinDist(beginning.getWeights().get(beginning.getNeighbors().indexOf(i)));
    		minHeap.insertNode(i);
    	}
    	
    	while(numcities>0) {
    		City use=minHeap.findMin();
    		minLength=use.getMinDist();
    		if(use.equals(dest)) {
    			return minLength;
    		}
    		
    		minHeap.clear(); //deletes all nodes in the heap
    			
    		
    		
    		
    	for(City i : use.getNeighbors()) {
    		int newweight=i.getWeights().get(i.getNeighbors().indexOf(use))+use.getMinDist();
    		
    		if(!used.contains(i)) {
    			
    			
    				//updates heap if distance is shorter
    			if(i.getMinDist()>newweight) {
    				i.setMinDist(newweight);
    				minHeap.insertNode(i);}
    		
    			else {
    				minHeap.insertNode(i);
    			}
    			}
    			 
    		
    			
    			
    			
    	
    		
    			
    	}
    	for()
    	used.add(use);
    	numcities--;
    	
    	
    	}
    	
        return minLength;
    }

    /**
     * findMinimumLength()
     *
     * @return The minimum total optical line length required to connect (span) each city on the given graph.
     * Assume the given graph is always connected.
     */
    public int findMinimumLength() {
    	int minLength=0;
    	ArrayList<City> used=new ArrayList<City>();
    	int numcities=cities.size()-1;
    	City beginning= cities.get(0);
    	used.add(beginning);
    	for(City i : beginning.getNeighbors()) {//puts all neighbors of city zero in heap
    		i.setMinDist(beginning.getWeights().get(beginning.getNeighbors().indexOf(i)));
    		minHeap.insertNode(i);
    	}
    	City use;
    	int newweight;
    	while(numcities>0) {
    		use=minHeap.findMin();
    		minLength=use.getMinDist();
    		 		
       		minHeap.clear(); //deletes all nodes in the heap
    	 	for(City i : use.getNeighbors()) {
    		newweight=i.getWeights().get(i.getNeighbors().indexOf(use))+use.getMinDist();
    		
    		if(!used.contains(i)) {

    				
    				i.setMinDist(newweight);
    				minHeap.insertNode(i);}
    				
    			 
    			
    			
    	}
    	used.add(use);
    	numcities--;
    	
    	
    	}
    	
        return minLength;
      
    }


    //returns edges and weights in a string.
    public String toString() {
        String o = "";
        for (City v : cities) {
            boolean first = true;
            o += "City ";
            o += v.getName();
            o += " has neighbors ";
            ArrayList<City> ngbr = v.getNeighbors();
            for (City n : ngbr) {
                o += first ? n.getName() : ", " + n.getName();
                first = false;
            }
            first = true;
            o += " with distances ";
            ArrayList<Integer> wght = v.getWeights();
            for (Integer i : wght) {
                o += first ? i : ", " + i;
                first = false;
            }
            o += System.getProperty("line.separator");

        }

        return o;
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public Heap getHeap() {
        return minHeap;
    }

    public ArrayList<City> getAllCities() {
        return cities;
    }

    // used by Driver class to populate each City with correct neighbors and corresponding weights
    public void setEdge(City curr, City neighbor, Integer weight) {
        curr.setNeighborAndWeight(neighbor, weight);
    }

    // used by Driver.java and sets cities to reference an ArrayList of all RestStops
    public void setAllNodesArray(ArrayList<City> x) {
        cities = x;
    }
}
