package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest
{
  @Test
  void testPush()
  {
    Stack<Integer> stack = new Stack<>();
    stack.push(5);

    assertEquals(5, stack.getTop().getValue());

    String string = stack.toString();
    String comparison = "5\n|\nNULL";
    System.out.println(string);
    System.out.println(comparison);

    assertEquals(string, comparison);
  }

  @Test
  void testPop()
  {
    Stack<Integer> stack = new Stack<>();

    stack.push(5);

    int value = stack.pop();

    assertEquals(value, 5);

    assertNull(stack.getTop());

  }

  @Test
  void testPopThrowsException()
  {
    Stack<Integer> stack = new Stack<>();

    assertThrows(NullPointerException.class, stack::pop);
  }

  @Test
  void testPeek()
  {
    Stack<Integer> stack = new Stack<>();

    stack.push(5);
    stack.push(7);

    assertEquals(stack.peek(), 7);

  }

  @Test
  void testPeekThrowsException()
  {
    Stack<Integer> stack = new Stack<>();

    assertThrows(NullPointerException.class, stack::peek);
  }

  @Test
  void testIsEmpty()
  {
    Stack<Integer> stack = new Stack<>();

    assertTrue(stack.isEmpty());

    stack.push(54);

    assertFalse(stack.isEmpty());
  }


}
