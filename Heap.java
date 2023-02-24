
/*
 * Name: <Olivia Parker>
 * EID: <osp257>
 */

// Implement your heap here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;

public class Heap {
    private ArrayList<City> minHeap;

    public Heap() {
        minHeap = new ArrayList<City>();
    }

    /**
     * buildHeap(ArrayList<City> cities)
     * Given an ArrayList of Cities, build a min-heap keyed on each City's minDist
     * Time Complexity - O(nlog(n)) or O(n)
     *
     * @param cities
     */
    public void buildHeap(ArrayList<City> cities) {
    	
    	for(City i:cities) {
    		insertNode(i);
    	}
    	
    	
        // TODO: implement this method
    }

    /**
     * insertNode(City in)
     * Insert a City into the heap.
     * Time Complexity - O(log(n))
     *
     * @param in - the City to insert.
     */
    public void insertNode(City in) {
    	minHeap.add(in);
    	City current=in;
    	while (((minHeap.indexOf(current)-1)/2)>=0 && current.getMinDist() < minHeap.get((minHeap.indexOf(current)-1)/2).getMinDist()) {
			swap(minHeap.indexOf(current), ((minHeap.indexOf(current)-1)/2));
			current = minHeap.get((minHeap.indexOf(current)-1)/2);
		}
    	// TODO: implement this method
    }

    /**
     * findMin()
     * Time Complexity - O(1)
     *
     * @return the minimum element of the heap.
     */
    public City findMin() {
    	return minHeap.get(0);
        // TODO: implement this method
       
    }

    /**
     * extractMin()
     * Time Complexity - O(log(n))
     *
     * @return the minimum element of the heap, AND removes the element from said heap.
     */
    public City extractMin() {
    	City popped = minHeap.get(0);
		delete(0);
		return popped;
        // TODO: implement this method
        
    }

    /**
     * delete(int index)
     * Deletes an element in the min-heap given an index to delete at.
     * Time Complexity - O(log(n))
     *
     * @param index - the index of the item to be deleted in the min-heap.
     */
    public void delete(int index) {
    	minHeap.remove(index);
    	if(minHeap.size()>0) {
    	minHeap.set(index, minHeap.get(minHeap.size()-1));
    	if(minHeap.size()!=1) {
    	minHeap.remove(minHeap.size()-1);}
    	City current=minHeap.get(index);
    	while (minHeap.indexOf(current)!=0 && current.getMinDist() < minHeap.get((minHeap.indexOf(current)-1)/2).getMinDist()) {
			swap(minHeap.indexOf(current), ((minHeap.indexOf(current)-1)/2));
			current = minHeap.get((minHeap.indexOf(current)-1)/2);
		}
    	minHeapify(minHeap.indexOf(current));
    	
    	}	
        // TODO: implement this method
    }

    /**
     * changeKey(City r, int newDist)
     * Changes minDist of City s to newDist and updates the heap.
     * Time Complexity - O(log(n))
     *
     * @param r       - the City in the heap that needs to be updated.
     * @param newDist - the new cost of City r in the heap (note that the heap is keyed on the values of minDist)
     */
    public void changeKey(City r, int newDist) {
    	r.setMinDist(newDist);
    	City current=r;
    	while (minHeap.indexOf(current)>=0 && current.getMinDist() < minHeap.get((minHeap.indexOf(current)-1)/2).getMinDist()) {
			swap(minHeap.indexOf(current), ((minHeap.indexOf(current)-1)/2));
			current = minHeap.get((minHeap.indexOf(current)-1)/2);
		}
    	minHeapify(minHeap.indexOf(current));
    	
        // TODO: implement this method
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < minHeap.size(); i++) {
            output += minHeap.get(i).getName() + " ";
        }
        return output;
    }
    
    private void swap(int x, int y) {
		City tmp;
		tmp = minHeap.get(x);
		minHeap.set(x, minHeap.get(y));
		minHeap.set(y, tmp);
	}
    
    private void minHeapify(int i) {
    	// If the node is a non-leaf node and any of its child is smaller
    	if(i<(minHeap.size())) {
    			if (( i*2+1 <minHeap.size() && minHeap.get(i).getMinDist() > minHeap.get((i*2)+1).getMinDist())||
    					i*2+2 <minHeap.size() && minHeap.get(i).getMinDist() > minHeap.get((i*2)+2).getMinDist()) {
    				if (minHeap.get(i).getMinDist() > minHeap.get((i*2)+1).getMinDist()) {
    					swap(i, ((i*2)+1));
    					i=(i*2)+1;
    					minHeapify(i);
    				} else {
    					swap(i, ((i*2)+2));
    					i=(i*2)+2;
    					minHeapify(i);
    				}
    			}
    	}
    		}
    	
  
   
    public void clear() {
    	minHeap.clear();
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public ArrayList<City> toArrayList() {
        return minHeap;
    }
}
