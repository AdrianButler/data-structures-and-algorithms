package treeintersection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TreeIntersection
{
  public static Set<Integer> treeIntersection(BinaryTree tree1, BinaryTree tree2)
  {
    Node current = tree1.root;
    HashMap<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    while (current != null)
    {
      map.put(current.value, current.value);
      current = current.leftChild;
    }
    current = tree1.root.rightChild;
    while (current != null)
    {
      map.put(current.value, current.value);
      current = current.rightChild;
    }

    current = tree2.root;
    while (current != null)
    {
      if (map.containsKey(current.value))
      {
        set.add(current.value);
      }
      current = current.leftChild;
    }
    current = tree2.root.rightChild;
    while (current != null)
    {
      if (map.containsKey(current.value))
      {
        set.add(current.value);
      }
      current = current.rightChild;
    }

    return set;
  }
}
