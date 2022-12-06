package treeintersection; //from https://github.com/dtfiedler/java-binary-tree/blob/master/src/BinaryTree.java

import java.util.LinkedList;
import java.util.Queue;

class Node {
  int value;
  Node leftChild;
  Node rightChild;

  //constructor to create a new node
  Node(int value){
    this.value = value;
    leftChild = null;
    rightChild = null;
  }
}

public class BinaryTree {

  Node root;

  //insert a node into the proper position based on it's value
  public void insert(int value){
    //recursively add from root
    root = addRecursive(root, value);
  }

  //determine if current tree contains node of certain value
  public boolean containsNode(int value){
    return containsNodeRecursive(root, value);
  }

  //delete node if exists from right subtree
  public void deleteNodeSmall(int value){
    deleteNodeRecursiveSmallest(root, value);
  }

  //delete node if exists from left subtree
  public void deleteNodeLarge(int value){
    deleteNodeRecursiveLargest(root, value);
  }


  //recursively add Nodes to binary tree in proper position
  private Node addRecursive(Node current, int value){
    //nothing set
    if (current == null){
      current = new Node(value);
      return current;
    }

    //1 check value compared to value of current node value
    if (value < current.value){
      //it goes to the left node
      current.leftChild = addRecursive(current.leftChild, value);
    } else {
      //it goes to the right node
      current.rightChild = addRecursive(current.rightChild, value);
    }

    return current;
  }

  //recursively search tree for node value
  private boolean containsNodeRecursive(Node current, int value){
    if (current == null){
      return false;
    }

    if (current.value == value){
      return true;
    }

    //determine if value is on left or right side of current node
    if (value < current.value){
      return containsNodeRecursive(current.leftChild, value);
    } else {
      return containsNodeRecursive(current.rightChild, value);
    }
  }

  public Node deleteNodeRecursiveLargest(Node current, int value){
    if (current == null){
      return null;
    }

    //we are at the node we want to delete
    if (current.value == value){
      //three scenarios

      //1. no children
      if (current.leftChild == null && current.rightChild == null){
        return null;
      }

      //only right child, return that to replace current node
      if (current.leftChild == null){
        return current.rightChild;
      }

      //only left child, return that to replace current node
      if (current.rightChild == null){
        return current.leftChild;
      }

      //hardest: node has two children
      //in this we want to traverse left subtree and get largest value, then replace that value of current node, and delete the node of the left subtree
      int largestValue = findLargestValue(current.leftChild);
      current.value = largestValue;
      current.leftChild = deleteNodeRecursiveLargest(current.leftChild, largestValue);
      return current;
    }

    //not at the right node, keep going
    if (value < current.value){
      //value is in left subtree
      current.leftChild = deleteNodeRecursiveLargest(current.leftChild, value);
      return current;
    }
    //value is in right subtree
    current.rightChild = deleteNodeRecursiveLargest(current.rightChild, value);
    return current;
  }

  private Node deleteNodeRecursiveSmallest(Node current, int value){
    //if null, return null
    if (current == null){
      return null;
    }

    if (current.value == value){
      //1. node has no left or right value, so just return null
      if (current.leftChild == null && current.rightChild == null) {
        return null;
      }

      //2.a. only one left child
      if (current.rightChild == null){
        return  current.leftChild;
      }

      //2.b. only one right child
      if (current.leftChild == null){
        return  current.rightChild;
      }

      //it has both children, need to traverse tree and find the lowest value of the right subtree
      int smallestValue = findSmallestValue(current.rightChild);
      //found the value, now rebuild right subtree by removing the value from it's previous spot
      current.value = smallestValue;
      current.rightChild = deleteNodeRecursiveSmallest(current.rightChild, smallestValue);
      return current;
    }

    //traverse until we delete it
    if(value < current.value){
      //value is less than current
      current.leftChild = deleteNodeRecursiveSmallest(current.leftChild, value);
      return current;
    }

    current.rightChild = deleteNodeRecursiveSmallest(current.rightChild, value);
    return current;
  }

  private int findSmallestValue(Node root){
    //if no left child, return root, else return lowest value of right tree (leaf)
    return root.leftChild == null ? root.value : findSmallestValue(root.rightChild);
  }

  private int findLargestValue(Node root){
    //if no left child, return root, else return lowest value of right tree (leaf)
    return root.rightChild == null ? root.value : findLargestValue(root.rightChild);
  }


  public Node getRoot(){
    return root;
  }


  //traverse tree in order (left, node, right)
  public void traverseInOrder(Node node){
    if (node != null){
      traverseInOrder(node.leftChild);
      System.out.print(" " + node.value);
      traverseInOrder(node.rightChild);
    }
  }

  //traverse left, right, node order
  public void traversePreOrder(Node node){
    if (node != null){
      System.out.print(" " + node.value);
      traversePreOrder(node.leftChild);
      traversePreOrder(node.rightChild);
    }
  }

  //traverse root, left, right
  public void traversePostOrder(Node node){
    if (node != null){
      if (node!= null){
        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.print(" " + node.value);
      }
    }
  }

  //Breadth first search (Level order searching)
  public void traverseLevelOrder(){
    if (root == null){
      return;
    }

    //Create a linked list of traversed nodes
    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);

    while (!nodes.isEmpty()){
      //remove the top node from the list and print it out
      Node node = nodes.remove();

      System.out.print(" " + node.value);

      //if it has a left child, add it to the list
      if (node.leftChild != null){
        nodes.add(node.leftChild);
      }

      //after we've added left child, add right child
      if (node.rightChild != null){
        nodes.add(node.rightChild);
      }
    }
    return;
  }
}
