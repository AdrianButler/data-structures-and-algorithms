package hashtable;

import hashtable.HashTable;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HashTableTest
{
  @Test
  void testHashTableStoresValue()
  {
    HashTable<String, Integer> hashTable = new HashTable<>(10);

    hashTable.set("one", 1);
    hashTable.set("two", 2);
    hashTable.set("three", 3);

    assertEquals(hashTable.get("one"), 1);
    assertEquals(hashTable.get("two"), 2);
    assertEquals(hashTable.get("three"), 3);
  }

  @Test
  void testHashTableCollision()
  {
    HashTable<String, Integer> hashTable = new HashTable<>(10);

    hashTable.set("Aa", 1);
    hashTable.set("BB", -1); // these two keys have the same hash code

    assertEquals(hashTable.get("Aa"), 1);
    assertEquals(hashTable.get("BB"), -1);
  }

  @Test
  void testHashTableKeys()
  {
    HashTable<String, Integer> hashTable = new HashTable<>(10);

    hashTable.set("One", 1);
    hashTable.set("Two", 2);

    ArrayList<String> keys = (ArrayList<String>) hashTable.keys();
    assertTrue(keys.contains("One"));
    assertTrue(keys.contains("Two"));
    assertFalse(keys.contains("Five"));
  }

  @Test
  void testHash()
  {
    HashTable<String, Integer> hashTable = new HashTable<>(10);


    assertEquals(hashTable.hash("One"), "One".hashCode() % 10);
    assertEquals(hashTable.hash("Two"), 4);
  }

  @Test
  void testHashTableReturnsNull()
  {
    HashTable<String, Integer> hashTable = new HashTable<>(10);

    hashTable.set("One", 1);
    hashTable.set("Two", 2);

    assertNull(hashTable.get("Three"));
  }


}
