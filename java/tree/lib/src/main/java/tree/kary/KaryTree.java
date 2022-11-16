package tree.kary;

import java.util.ArrayList;
import java.util.List;

public class KaryTree <T>
{
  private KaryNode<T> root;

  public KaryTree()
  {
  }

  public static <K> KaryTree<String> fizzBuzzTree(KaryTree<K> karyTree)
  {
    List<K> breadthFirstList = new ArrayList<>();
    List<KaryNode<K>> queue = new ArrayList<>();
    KaryTree<String> stringKaryTree = new KaryTree<>();

    queue.add(karyTree.getRoot());
    KaryNode<String> newRoot = new KaryNode<>(fizzBuzz((int)karyTree.getRoot().getValue()));
    stringKaryTree.setRoot(newRoot);


    while (!queue.isEmpty())
    {
      KaryNode<K> current = queue.remove(0);
      int value = (int) current.getValue();
      String result = fizzBuzz(value); // changes value to fizz buzz result
      KaryNode<String> newNode = new KaryNode<>(result);

      List<KaryNode<K>> children = current.getChildren();

      for (int i = 0; i < children.size(); i++)
      {

      }

      queue.addAll(current.getChildren());
    }

    return null;
  }

  private static String fizzBuzz(int value)
  {
    if (value % 3 == 0 && value % 5 == 0)
    {
      return "fizzbuzz";
    }
    else if (value % 3 == 0)
    {
      return "fizz";
    }
    else if (value % 5 == 0)
    {
      return "buzz";
    }
    else
    {
      return value + "";
    }
  }


  public KaryNode<T> getRoot()
  {
    return root;
  }

  public void setRoot(KaryNode<T> root)
  {
    this.root = root;
  }
}
