/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Lenovo
 */
public class BFSandDFSApp {
   public static void main(String[] args)
      {
      Graph theGraph = new Graph();
      theGraph.addVertex('A');    // 0  (start for bfs)
      theGraph.addVertex('B');    // 1
      theGraph.addVertex('C');    // 2
      theGraph.addVertex('D');    // 3
      theGraph.addVertex('E');    // 4

      theGraph.addEdge(0, 1);     // AB
      theGraph.addEdge(1, 2);     // BC
      theGraph.addEdge(0, 3);     // AD
      theGraph.addEdge(3, 4);     // DE

      System.out.print("Visits Using BFS Algorithm: ");
      theGraph.bfs();            // Breadth First Search
      System.out.println();
      
      System.out.println();

      System.out.print("Visits Using DFS Algorithm:: ");
      theGraph.dfs();             // depth-first search
      System.out.println();
      
      System.out.println();

      theGraph.display();
     
      }  
   }  
////////////////////////////////////////////////////////////////

