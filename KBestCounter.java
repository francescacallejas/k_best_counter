/*Francesca Callejas
 *ffc2108
 *
 *Homework 4
 *KBestCounter
 *This class creates returns the largest values of a given input using heap.
 */

import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int k){

        this.k = k;
        heap = new PriorityQueue<T>();
    }


    //this method decides if and how to add an element to the heap
    public void count(T x){

	/*if there are already k elements in the heap, only add element
         if it is larger than the root */
	if(heap.size() == k){
	    if(x.compareTo(heap.peek()) < 1){
                 ;
            }else if(x.compareTo(heap.peek()) >= 1){
                heap.add(x);
		heap.remove();
		
            }
        }


	//if less than k elements, always add it
	else if(heap.size() < k){
            heap.add(x);
	    System.out.println("added: " + x);
        }

    }


    public List<T> kbest(){

        LinkedList<T> largestElements = new LinkedList<T>();

	PriorityQueue<T> heapcopy = new PriorityQueue<T>(); 
	//copy to avoid tampering original

	System.out.println(heap);
	int i = 0; 
        while(!heap.isEmpty()){	     
	    T item = heap.remove();
	    heapcopy.add(item);
            largestElements.addFirst(item);
	    i++;
        }

	heap = heapcopy; 

        return largestElements;

    }
}
