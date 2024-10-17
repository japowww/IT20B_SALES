
package it20b_sales.queue;

import java.util.Queue;
import java.util.LinkedList;
public class IT20B_SALESQueue {

    public static void main(String[] args) {
    Queue<String> prots = new LinkedList<>();
    
    prots.add("apple");
    prots.add("orange");
    prots.add("grapes");
    
     String firstElement = prots.poll(); 
       
    
     System.out.println("Remaining elements in the queue: " + prots);
        System.out.println("Prutas: "+ prots);
    
    }
    
    
    
}
