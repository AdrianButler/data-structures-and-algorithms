# Hashtable

## Challenge

Implement a custom hashtable

## Approach & Efficiency

I created my hashtable with a ArrayList that contains a linkedlist that contains a hashtable pair. When the set and get methods are called the key is hashed and both the key and value are stored at that index in the arraylist and inside that linkedlist as a hashtablepair. This method allows collisions and handles them appropriately.

## API

### Methods

Get(key) - returns the value of the key
Set(key, value) - sets the key to the value
Hash(key) - hashes the key to an index
Has(key) - returns true if the key is in the hashtable
Keys() - returns an Iterable of all the keys in the hashtable
hash(key) - hashes the key to an index in the arraylist
Constructor(size) - creates a hashtable with the set size
