package stack.and.queue;

import linked.list.Node;

public class Stack<T>
{
  private Node<T> top;

  public void push(T value)
  {
    Node<T> newNode = new Node<>(value);
    if (top != null)
    {
      newNode.setNext(top);
    }
    top = newNode;
  }

  public T pop()
  {
    try
    {
      T value = top.getValue();
      top = top.getNext();
      return value;
    }
    catch (NullPointerException exception)
    {
      throw new NullPointerException();
    }
  }

  public T peek()
  {
    try
    {
      return top.getValue();
    }
    catch (NullPointerException exception)
    {
      throw new NullPointerException();
    }
  }

  public boolean isEmpty()
  {
    return top == null;
  }

  public Node<T> getTop()
  {
    return top;
  }

  @Override
  public String toString()
  {
    String string = "";
    Node<T> current = top;
    while (current != null)
    {
      System.out.println(current.getValue());
      string += current.getValue() + "\n|\n";
      current = current.getNext();
    }
    string += "NULL";
    return string;
  }
}
