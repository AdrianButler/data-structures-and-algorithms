package animal.shelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest
{
  @Test
  void testEnqueue()
  {
    AnimalShelter animalShelter = new AnimalShelter();

    animalShelter.enqueue(new Dog());
    animalShelter.enqueue(new Dog());
    animalShelter.enqueue(new Dog());
    animalShelter.enqueue(new Cat());

    String string = animalShelter.toString();
    String comparison = "dogdogdogcat";

    assertEquals(string, comparison);
  }

  @Test
  void testDequeue()
  {
    AnimalShelter animalShelter = new AnimalShelter();

    animalShelter.enqueue(new Dog());
    animalShelter.enqueue(new Dog());
    animalShelter.enqueue(new Dog());
    animalShelter.enqueue(new Cat());
    animalShelter.enqueue(new Cat());
    animalShelter.enqueue(new Cat());



    Animal cat = animalShelter.dequeue("cat");
    String string = animalShelter.toString();
    String comparison = "dogdogdogcatcat";

    assertEquals(cat.getType(), "cat");

    assertEquals(comparison, string);
  }

}
