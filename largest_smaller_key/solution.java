import java.io.*;
import java.util.*;

class Solution {
 
  static class Node {
    int key;
    Node left;
    Node right; 
    Node parent;
    
    Node(int key) {
      this.key = key;
      left = null;
      right = null;
      parent = null;
    }
  }
  
  static class BinarySearchTree {
    
    Node root;
    
    int findLargestSmallerKey(int num) {
      Node currentNode = root;
      
      while (currentNode != null) {
        if (currentNode.key < num && (currentNode.right == null || currentNode.right.key >= num))
          return currentNode.key;
        
        if (currentNode.key > num)
          currentNode = currentNode.left;
        else 
          currentNode = currentNode.right;
      }
      
      return -1;
    }
    
    void insert(int key) {
      
      if(this.root == null) {
        this.root = new Node(key);
        return;
      }
      
      Node currentNode = this.root;
      Node newNode = new Node(key); 
      
      while(currentNode != null) {
        if(key < currentNode.key) {
          if(currentNode.left == null) {
            currentNode.left = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if(currentNode.right == null) {
            currentNode.right = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
  }

  /*********************************************
   * Driver program to test above function     *
   *********************************************/ 
   
   public static void main(String[] args) {
     
     // Create a Binary Search Tree
     BinarySearchTree bst = new BinarySearchTree();
     bst.insert(20);
     bst.insert(9);
     bst.insert(25);
     bst.insert(5);     
     bst.insert(6);
     bst.insert(12);
     bst.insert(11);
     bst.insert(14);
     bst.insert(19);
     bst.insert(21);
     
     int result = bst.findLargestSmallerKey(6);
     System.out.println("Largest smaller number is " + result);
    
  }
}
