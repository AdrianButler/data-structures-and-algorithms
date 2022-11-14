package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeMaxTest
{
  @Test
  public void testFindMax()
  {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    binaryTree.setRoot(new BinaryNode<>(1));
    binaryTree.getRoot().setLeft(new BinaryNode<>(2));
    binaryTree.getRoot().setRight(new BinaryNode<>(3));
    binaryTree.getRoot().getLeft().setLeft(new BinaryNode<>(4));
    binaryTree.getRoot().getLeft().setRight(new BinaryNode<>(5));
    binaryTree.getRoot().getRight().setLeft(new BinaryNode<>(6));
    binaryTree.getRoot().getRight().setRight(new BinaryNode<>(7));

    assertEquals(7, binaryTree.findMax());
  }
}
