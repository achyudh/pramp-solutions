import java.io.*;
import java.util.*;

class Solution {
  
  static class Pair {
    Node node;
    int cost;
    
    public Pair(Node node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }
  
  static class Node {
      
    int cost;
    Node[] children;
    Node parent;

    Node(int cost) {
      this.cost = cost;
      children = null;
      parent = null;
    }
  }

  static class SalesPath {
        
    int getCheapestCost(Node rootNode) {
      int minCost = Integer.MAX_VALUE;
      LinkedList<Pair> queue = new LinkedList<>();
      queue.add(new Pair(rootNode, rootNode.cost));
      
      while (!queue.isEmpty()) {
        
        Pair currentPair = queue.poll();
        Node currentNode = currentPair.node;
        int currentCost = currentPair.cost;
        
        if (currentNode.children != null)
          for (Node child : currentNode.children)
            queue.add(new Pair(child, currentCost + child.cost));
        
        else if (currentCost < minCost)
            minCost = currentCost;
      }
      
      return minCost;
    }
  }

  
  public static void main(String[] args) {   
    Node root = new Node(0);
    Node child5 = new Node(5);
    Node child3 = new Node(3);
    Node child6 = new Node(6);
    root.children = new Node[] {child5, child3, child6};
    
    Node child4 = new Node(4);
    child5.children = new Node[] {child4};
    
    Node child2 = new Node(2);
    Node child0 = new Node(0);
    child3.children = new Node[] {child2, child0};
   
    SalesPath sp = new SalesPath();
    System.out.println(sp.getCheapestCost(root));
  }
}
