package stack.and.queue;

import linked.list.Node;

public class Queue<T>
{
  private Node<T> front;

  public void enQueue(T value)
  {
    Node<T> newNode = new Node<T>(value);
    Node<T> current = front;
    if (current == null)
    {
      front = newNode;
    }
    else
    {

      while (current != null && current.getNext() != null)
      {
        current = current.getNext();
      }

      current.setNext(newNode);
    }

  }

  public T dequeue()
  {
    try
    {
      T value = front.getValue();
      front = front.getNext();
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
      return front.getValue();
    }
    catch (NullPointerException exception)
    {
      throw new NullPointerException();
    }
  }

  public boolean isEmpty()
  {
    return front == null;
  }

  public Node<T> getFront()
  {
    return front;
  }

  @Override
  public String toString()
  {
    String string = "";
    Node<T> current = front;

    while (current != null)
    {
      string += front.getValue() + " > ";
      current = current.getNext();
    }

    string += "NULL";

    return string;
  }
}
