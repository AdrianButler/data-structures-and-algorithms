package tree.kary;

import java.util.ArrayList;

public class KaryNode <T>
{
  private T value;
  private ArrayList<KaryNode<T>> children;

  public KaryNode(T value)
  {
    this.value = value;
  }

  public T getValue()
  {
    return value;
  }

  public void setValue(T value)
  {
    this.value = value;
  }

  public ArrayList<KaryNode<T>> getChildren()
  {
    return children;
  }

  public void setChildren(ArrayList<KaryNode<T>> children)
  {
    this.children = children;
  }
}
