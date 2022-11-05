package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest
{
  @Test
  void testEnqueue()
  {
    Queue<Integer> queue = new Queue<>();

    queue.enQueue(4);

    assertEquals(queue.getFront().getValue(), 4);

    String string = queue.toString();
    String comparison = "4 > NULL";
    assertEquals(string, comparison);

  }

  @Test
  void testDequeue()
  {
    Queue<Integer> queue = new Queue<>();

    queue.enQueue(5);
    queue.enQueue(3);
    queue.enQueue(2);

    assertEquals(queue.peek(), 5);

    int value = queue.dequeue();

    assertEquals(value, 5);

    assertEquals(queue.peek(), 3);
  }

  @Test
  void testDequeueThrowsException()
  {
    Queue<Integer> queue = new Queue<>();

    assertThrows(NullPointerException.class, queue::dequeue);
  }

  @Test
  void testPeek()
  {
    Queue<Integer> queue = new Queue<>();

    queue.enQueue(5);

    assertEquals(queue.peek(), 5);
  }

  @Test
  void testPeekThrowsException()
  {
    Queue<Integer> queue = new Queue<>();

    assertThrows(NullPointerException.class, queue::peek);
  }

  @Test
  void testIsEmpty()
  {
    Queue<Integer> queue = new Queue<>();

    assertTrue(queue.isEmpty());

    queue.enQueue(12);

    assertFalse(queue.isEmpty());
  }

}
