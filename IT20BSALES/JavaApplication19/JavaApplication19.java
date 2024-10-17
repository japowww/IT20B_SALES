
package javaapplication19;

import java.util.LinkedList;


public class JavaApplication19 {

   
    public static void main(String[] args) {
       LinkedList<String> poods = new LinkedList<>();

      
        poods.add("binignit");
        poods.addFirst("pares");
        poods.addLast("kornbip");
        poods.add(1, "Majic sarap");

  
        System.out.println("Poods: " + poods);
        System.out.println("Size: " + poods.size());
        
        if(poods.contains("pares")){
            System.out.println("Gwapo ka");}
        else{
            System.out.println("wakay lami");
        }
        
            boolean containspares = poods.contains("pares");
            System.out.println(containspares);
               
    }
    
}
