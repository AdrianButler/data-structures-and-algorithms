package animal.shelter;

import linked.list.Node;
import stack.and.queue.Queue;

public class AnimalShelter
{
  private Queue<Animal> animals = new Queue<>();

  public void enqueue(Animal animal)
  {
    animals.enQueue(animal);
  }

  public Animal dequeue(String pref)
  {
    String type = animals.peek().getType();

    if (pref.equals(type))
    {
      return animals.dequeue();
    }
    else
    {
      Queue<Animal> newAnimals = new Queue<>();
      Animal current = animals.dequeue();
      while (!current.getType().equals(pref))
      {
        newAnimals.enQueue(current);
        current = animals.dequeue();
        if (current == null)
        {
          animals = newAnimals;
          return null;
        }
      }

      mergeQueue(newAnimals, animals);
      animals = newAnimals;
      return current;
    }
  }

  private void mergeQueue(Queue<Animal> queue1, Queue<Animal> queue2)
  {
    Animal current = queue2.dequeue();

    while (current != null)
    {
      queue1.enQueue(current);
      try
      {
        current = queue2.dequeue();
      }
      catch (Exception exception)
      {
        return;
      }

    }
  }

  @Override
  public String toString()
  {
    String string = "";

    Node<Animal> current = animals.getFront();
    while (current != null)
    {
      string += current.getValue().getType();
      current = current.getNext();
    }

    return string;
  }
}
