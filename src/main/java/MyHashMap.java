import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<T> implements Iterable<T>{
	ArrayList<GenericQueue<T>> map;//holds the hashmap of generic queues that are used for collisions
	int size;
	GenericList<T>.Node<T> head;//used for iterator
	
	//contructor for MyHashMap
	public MyHashMap(String key, T value){
		map = new ArrayList<GenericQueue<T>>(10);
		size = 0;
		//initializes arraylist to size 10
		for(int i = 0; i < 10; i++)
			map.add(null);
		this.put(key, value);

	}
	
	//takes a key value pair and creates a hash code/hash value to add to the hash map
	public void put(String key, T value) {
		int code = Math.abs(key.hashCode()%10);// the code value
		GenericQueue<T> currentQueue = map.get(code);//this is the queue (if there is one) at the index that is calculated from the key

		if(currentQueue == null) {//if there is no queue at the index of the hash map yet, we will need to make one
			GenericQueue<T> q = new GenericQueue<T>(value, key.hashCode());//creates new queue
			map.set(code, q);//sets a newly created queue to the index that is made from the hashCode provided
		}
		else {
			currentQueue.enqueue(value, key.hashCode());//adds to the end of the queue with the new node
		}
		
		size++;
	}
	
	//function that checks if the hash map contains a certain key
	public boolean contains(String key) {
		int code = Math.abs(key.hashCode()%10);// the code value to be looking for
		GenericQueue<T> currentQueue = map.get(code);//this is the queue (if there is one) at the index that is calculated from the key
		if(currentQueue == null) {//if there is no queue at the specified key, the value definitely does not exist
			return false;
		}
		else {
			return currentQueue.contains(key.hashCode());//returns if the hashCode derived from the key is found in the queue
		}
	}
	
	//function that returns the value of a node at a specified key
	public T get(String key) {
		int code = Math.abs(key.hashCode()%10);// the code value to be looking for
		if(!this.contains(key)) {//checks if it is within the queue before trying to acquire the value
			return null;
		}
		else {
			GenericQueue<T> currentQueue = map.get(code);
			GenericQueue<T>.Node<T> temp = currentQueue.getHead(); 
			while(temp != null) {
				if(key.hashCode() == temp.getCode())
					return temp.getData();
				temp = temp.getNext();
			}
		}
		return null;
	}
	
	//returns the amount of key value pairs in the hashMap
	public int size() {
		return size;
	}
	
	//checks if there is nothing in the hashmap
	public boolean isEmpty() {
		return (size==0);
	}
	
	//replace() function used for replacing values at given indices.
	public T replace(String key, T value) {
		int code = Math.abs(key.hashCode()%10);
		if(this.contains(key)) {//checks if the key currently exists in the map
			T temp = this.get(key);
			GenericQueue<T>.Node<T> it = map.get(code).getHead();//starts at the beginning of the queue
			while(it != null) {
				if(key.hashCode() == it.getCode()) {
					it.setData(value);
					return temp;
				}
				it = it.getNext();
			}
			return null;
		}
		else {//if the key does not exist, do nothing and return null
			return null;
		}
	}
	@Override
	public Iterator<T> iterator() {
		return new HMIterator<T>(this);
	}
	
}