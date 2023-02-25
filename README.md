# GenericClasses
Created a Generic List in Java, which was used to create Generic Queue, which was then used to create Generic Hash Map.

## Important Files:
- src/main/java:
  - GenericList.java - GenericList, an abstract class used to implement methods such as get(), print(), set(), and used in Generic Queue.
  - GLLIterator.java - An iterator class was created that implemented the Iterator interface to use in our Generic List.
  - ReverseGLLIterator.java - An iterator class that works very similar to GLLIterator, but starts at the end of the list, and goes backwards.
  - GenericQueue.java - GenericQueue, a class that extends GenericList, was created to serve as a queue structure that worked with any data type.
  - MyHashMap.java - MyHashMap, a class that implements Iterable, uses GenericQueue to create a hashmap structure with any data type.
  - HMIterator.java - An iterator class that is used to iterate through hashmaps, specifically.

- src/test/java:
  - GQTest.java - Tests all functionalities and methods of GenericQueue.
  - HMTest.java - Tests all functionalities and methods of MyHashMap
