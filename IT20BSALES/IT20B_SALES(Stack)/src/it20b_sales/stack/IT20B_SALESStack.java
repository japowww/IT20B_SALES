
package it20b_sales.stack;

import java.util.Stack;
public class IT20B_SALESStack {

 
    public static void main(String[] args) {
        Stack<String> jollibee = new Stack<>();
        
        jollibee.push("Burger");
        jollibee.push("Fries");
        jollibee.push("Coke");
        
        System.out.println("Jollibee:"+ jollibee);
        
        String topElement = jollibee.pop();
        System.out.println("poped:" + topElement);
        
        String peekedElement = jollibee.peek();
        System.out.println("Peeked: "+ peekedElement);
        
        boolean isEmpty = jollibee.isEmpty();
        System.out.println("Empty: "+ isEmpty);
       
        
    }
    
}
