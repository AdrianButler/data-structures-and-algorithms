package hashtable;

public class HashTablePair<K, V>
{
  private final K key;
  private V value;

  private HashTablePair<K, V> next;

  public HashTablePair(K key, V value)
  {
    this.key = key;
    this.value = value;
  }

  public K getKey()
  {
    return key;
  }

  public V getValue()
  {
    return value;
  }

  public void setValue(V value)
  {
    this.value = value;
  }

  public HashTablePair<K, V> getNext()
  {
    return next;
  }

  public void setNext(HashTablePair<K, V> next)
  {
    this.next = next;
  }


}
