package stack.pseudo.queue;

import java.util.Stack;

public class PsuedoQueue {
  Stack<Integer> stack = new Stack<>();

  public void enqueue(Integer val)
  {
    stack.push(val);
  }

  public Integer dequeue()
  {
    return stack.pop();
  }
}
