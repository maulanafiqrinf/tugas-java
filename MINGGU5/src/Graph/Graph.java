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
class Graph {
   private final int MAX_VERTS = 20;
   private Vertex vertexList[]; 
   private int adjMat[][];      
   private int nVerts;          
   private Queue theQueue;
   private StackX theStack;
   
   public Graph()               
      {
      vertexList = new Vertex[MAX_VERTS];
                                         
      adjMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      for(int j=0; j<MAX_VERTS; j++)      
         for(int k=0; k<MAX_VERTS; k++)   
            adjMat[j][k] = 0;
      theQueue = new Queue();
      theStack = new StackX();
      }  
   
   public void addVertex(char lab)
      {
      vertexList[nVerts++] = new Vertex(lab);
      }

   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      adjMat[end][start] = 1;
      }

   public void displayVertex(int v)
      {
      System.out.print(vertexList[v].label);
      }

   public void bfs()                   // breadth-first search
      {                                // begin at vertex 0
      vertexList[0].wasVisited = true; // mark it
      displayVertex(0);                // display it
      theQueue.insert(0);              // insert at tail
      int v2;

      while( !theQueue.isEmpty() )     
         {
         int v1 = theQueue.remove();   
         
         while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
            {                                  
            vertexList[v2].wasVisited = true;  
            displayVertex(v2);                 
            theQueue.insert(v2);               
            }   
         }  
      
      for(int j=0; j<nVerts; j++)             // reset flags
         vertexList[j].wasVisited = false;
      }  
   
   public void dfs() // depth-first search
    {                                 // begin at vertex 0
        vertexList[0].wasVisited = true;  // membuat
        displayVertex(0);                 // menampilkan
        theStack.push(0);                 // mendorong

        while (!theStack.isEmpty()) // sampai tumpukan kosong
        {
 
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) 
            {
                theStack.pop();
            } else // if it exists,
            {
                vertexList[v].wasVisited = true;  // membuat
                displayVertex(v);                 // menampilkan 
                theStack.push(v);                 //mendorong
            }
        }  

        
        for (int j = 0; j < nVerts; j++) // reset flags
        {
            vertexList[j].wasVisited = false;
        }
    }  

   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  
   
   public void display() {
        System.out.println("Adjecency: ");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < row; col++) {
                if ( adjMat[row][col] == 1) {
                    System.out.println(
                            vertexList[row].label + " -- " + vertexList[col].label);
                }
            }
        }
        System.out.println("");
   }
   }  
