package tree;

import org.junit.jupiter.api.Test;
import tree.kary.KaryNode;
import tree.kary.KaryTree;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KaryTest
{
  @Test
  public void testKaryTreeInstantiation()
  {
      KaryTree<Integer> karyTree = new KaryTree<>();
      assertNull(karyTree.getRoot());
  }

  @Test
  public void testKaryTreeFizzBuzz()
  {
    KaryNode<Integer> root = new KaryNode<>(10);
    KaryTree<Integer> karyTree = new KaryTree<>();
    karyTree.setRoot(root);

    KaryNode<Integer> child1 = new KaryNode<>(15);
    KaryNode<Integer> child2 = new KaryNode<>(3);
    KaryNode<Integer> child3 = new KaryNode<>(12);
    KaryNode<Integer> child4 = new KaryNode<>(7);

    ArrayList<KaryNode<Integer>> children = new ArrayList<>();
    children.add(child1);
    children.add(child2);
    children.add(child3);
    children.add(child4);

    karyTree.getRoot().setChildren(children);

    KaryTree<String> stringKaryTree = KaryTree.fizzBuzzTree(karyTree);

    assertEquals("buzz", stringKaryTree.getRoot().getValue());
    assertEquals("fizzbuzz", stringKaryTree.getRoot().getChildren().get(0).getValue());
    assertEquals("fizz", stringKaryTree.getRoot().getChildren().get(1).getValue());
    assertEquals("fizz", stringKaryTree.getRoot().getChildren().get(2).getValue());
    assertEquals("7", stringKaryTree.getRoot().getChildren().get(3).getValue());
  }
}
