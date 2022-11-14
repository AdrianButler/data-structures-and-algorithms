package tree;

import java.util.ArrayList;

public class BinaryTree<T>
{
  private BinaryNode<T> root;
  private ArrayList<T> tempTraversalArray;

public T findMax()
  {
    ArrayList<T> values = preOrderTraversal();
    T maxValue = values.get(0);
    for (T value : values)
    {
      if ((int) value > (int)maxValue)
      {
        maxValue = value;
      }
    }
    return maxValue;
  }

  public ArrayList<T> preOrderTraversal()
  {
    tempTraversalArray = new ArrayList<>();

    preOrder(root);

    return new ArrayList<>(tempTraversalArray);
  }

  private void preOrder(BinaryNode<T> node)
  {
    if (node != null)
    {
      tempTraversalArray.add(node.getValue());
      preOrder(node.getLeft());
      preOrder(node.getRight());
    }
  }

  public T[] inOrder(BinaryNode<T> node)
  {
    return null;
  }

  public T[] postOrder(BinaryNode<T> node)
  {
    return null;
  }

  public BinaryNode<T> getRoot()
  {
    return root;
  }

  public void setRoot(BinaryNode<T> root)
  {
    this.root = root;
  }
}
