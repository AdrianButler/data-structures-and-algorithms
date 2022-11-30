package hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<K, V>
{
  private final int size;

  private final ArrayList<LinkedList<HashTablePair<K, V>>> table;

  public HashTable(int size)
  {
    this.size = size;
    table = new ArrayList<>(size);

    for (int i = 0; i < size; i++)
    {
      table.add(new LinkedList<>());
    }
  }

  public void set(K key, V value)
  {
    int index = key.hashCode() % size;
    HashTablePair<K, V> pair = new HashTablePair<>(key, value);
    LinkedList<HashTablePair<K, V>> linkedList = table.get(index);
    linkedList.add(pair);
  }

  public V get(K key)
  {
    int index = key.hashCode() % size;
    LinkedList<HashTablePair<K, V>> linkedList = table.get(index);

    for (HashTablePair<K, V> pair : linkedList)
    {
      if (pair.getKey().equals(key))
      {
        return pair.getValue();
      }
    }

    return null;
  }

  public boolean has(K key)
  {
    int index = key.hashCode() % size;
    LinkedList<HashTablePair<K, V>> linkedList = table.get(index);

    for (HashTablePair<K, V> pair : linkedList)
    {
      if (pair.getKey().equals(key))
      {
        return true;
      }
    }

    return false;
  }

  public Iterable<K> keys()
  {
    ArrayList<K> keys = new ArrayList<>();

    for (LinkedList<HashTablePair<K, V>> linkedList : table)
    {
      for (HashTablePair<K, V> pair : linkedList)
      {
        keys.add(pair.getKey());
      }
    }

    return keys;
  }

  public int hash(K key)
  {
    return key.hashCode() % size;
  }


}
