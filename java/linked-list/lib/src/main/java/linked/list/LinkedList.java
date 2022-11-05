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

  public boolean isPalindrome()
  {
    String string = "";
    Node<T> current = head;

    while (current != null)
    {
      string += current.getValue();
      current = current.getNext();
    }

    String reversedString = reverseString(string);

    return string.equals(reversedString);
  }

  private String reverseString(String string)
  {
    String newString = "";
    for (int i = string.length(); i > 0; --i)
    {
      newString += string.charAt(i - 1);
    }

    return newString;
  }

  public static <T> LinkedList<T> zipLists(Node<T> current1, Node<T> current2)
  {
    final Node<T> head = current1;

    Node<T> temp1 = current1.getNext();
    Node<T> temp2 = current2.getNext();
    while (true)
    {
      current1.setNext(current2);
      current1 = temp1;
      current2.setNext(current1);

      if (temp1 == null)
      {
        break;
      }
      temp1 = temp1.getNext();
      current2 = temp2;
      temp2 = current2.getNext(); // loop?
    }

    LinkedList<T> newLinkedList = new LinkedList<>();
    newLinkedList.setHead(head);

    return newLinkedList;
  }
  public T kthFromEnd(int k)
  {
    int counter = 0;

    LinkedList<T> reversed = reverseLinkedList(this);
    Node<T> current = reversed.getHead();

    while (current != null)
    {
      if (counter == k)
      {
        return current.getValue();
      }
      counter++;
      current = current.getNext();
    }

    return null;
  }

  public LinkedList<T> reverseLinkedList(LinkedList<T> linkedList)
  {
    Node<T> previous = null;
    Node<T> current = linkedList.head;
    Node<T> temp = current.getNext();

    while (current != null)
    {
      current.setNext(previous);
      previous = current;
      current = temp;
      temp = current.getNext();
    }

    linkedList.setHead(previous);

    return linkedList;
  }

  public void setHead(Node<T> head)
  {
    this.head = head;
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
