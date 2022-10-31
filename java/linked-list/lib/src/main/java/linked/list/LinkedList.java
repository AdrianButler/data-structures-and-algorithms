/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linked.list;

public class LinkedList<T>
{
  private Node<T> head;

  public Node<T> getHead()
  {
    return head;
  }

  public void append(T value)
  {
    Node<T> current = head;

    if (current == null)
    {
      head = new Node<>(value);
      return;
    }

    while (current.getNext() != null)
    {
      current = current.getNext();
    }

    current.setNext(new Node<>(value));


  }

  public void insertBefore(T value, T newValue)
  {
    Node<T> current = head;
    Node<T> previousNode = current;

    if (current == null)
    {
      return;
    }

    while (current.getValue() != value)
    {
      if (current.getNext() == null)
      {
        return;
      }
      previousNode = current;
      current = current.getNext();
    }

    Node<T> insertedNode = new Node<>(newValue);

    previousNode.setNext(insertedNode);
    insertedNode.setNext(current);
  }

  public void insertAfter(T value, T newValue)
  {
    Node<T> current = head;

    if (current == null)
    {
      return;
    }

    while (current.getValue() != value)
    {
      if (current.getNext() == null)
      {
        return;
      }
      current = current.getNext();
    }

    Node<T> insertedNode = new Node<>(newValue);

    insertedNode.setNext(current.getNext());
    current.setNext(insertedNode);
  }

  public void insert(T value)
  {
    Node<T> newNode = new Node<>(value);
    newNode.setNext(head);

    head = newNode;
  }

  public boolean includes(int value)
  {
    Node<T> current = head;

    while (current != null)
    {
      if (current.getValue().equals(value))
      {
        return true;
      }
      current = current.getNext();
    }

    return false;
  }

  @Override
  public String toString()
  {
    String values = "";

    Node<T> current = head;

    while (current != null)
    {
      values += "{ " + current.getValue() + " } -> ";
      current = current.getNext();
    }

    values += "NULL";

    return values;
  }
}
