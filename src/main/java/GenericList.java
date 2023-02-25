import java.util.ArrayList;
import java.util.Iterator;

/*
 * Author: Syed Shaban
 * NetID: sshab3
 * Description: Implements the GenericList class used in rest of the project that implements the "Iterable" interface(Generic Abstract Class)
 * 
 * */

public abstract class GenericList<T> implements Iterable<T>{
	
	/*
	 * Inner classes:
	 * Node
	 */
	
	public class Node<T>{//defines the node class which holds each node in the genericList
		T data;
		int code;
		Node<T> next;
		
		//constructors for Node class
		public Node(T data, int code, Node<T> next) {
			this.data = data;
			this.code = code;
			this.next = next;
		}
		
		public Node(T data) {
			this.data = data;
		}
		
		//Setter methods for Data, Code, and Next data members
		public void setData(T data) {
			this.data = data;
		}
		public void setNext(Node<T> next) {
			this.next = next;
					
		}
		public void setCode(int code) {
			this.code = code;
		}
		
		//Getter methods for Data, Code, and Next data members
		public T getData() {
			return data;
		}
		public Node<T> getNext() {
			return next;
		}
		public int getCode() {
			return code;
		}
	}
		
	/*
	 * Data member variables of Generic list:
	 * Head, and length
	 */
		private Node<T> head;//holds the head of the list
		private int length;//the length of the list
		
		
		//overrides the Iterator method from iterable
		public Iterator<T> iterator(){
			return new GLLIterator<T>(this);
		}
		
	/*
	 * Functions for us to implement:
	 */
		//function used to print out each element in the generic list
		public void print() {
			if(this.length == 0) {//checks to make sure there is something inside of the list
				System.out.println("Empty List");
				return;
			}
			//alternate ways to print
			/*Node<T> temp = this.head;//creates a node iterator to go through the list to print each element
			while(temp != null) {//while the iterator is not null
				System.out.println(temp.getData());
				temp = temp.getNext();
			}*/
			System.out.println("Contents of the list:");
			this.forEach(e->System.out.print(e + " "));//prints each element in the list*/
			System.out.println("");
			/*Iterator<T> i = this.iterator();
			while(i.hasNext()) {//Goes until the last element
				System.out.println(i.next());//prints each element in the list
			}*/
		}
		
		//abstract methods that changes its implementation depending on data structure:
		public abstract void add(T data);
		public abstract T delete();
		
		//returns the value at the specified index or null if the index is out of bounds
		public T get(int index) {
			if (this.length <= index) {//checks for out of bound exceptions
				return null;
			}
			Iterator<T> i = this.iterator();//creates an iterator to iterate through the list to find the item
			int counter = 0;
			while(i.hasNext()) {//loops until the end of the list
				if(counter == index) {//when we reach the correct index, return the element
					return i.next();//returns the element
				}
				counter++;//if we aren't at the correct index yet, just increment the counter and the iterator
				i.next();
			}
			return null;
			/*
			 * implements get() function without iterator
			Node<T> i = this.head;//creates an iterator that starts at the head of the queue
			int counter = 0;
			while(counter < index) {//iterates through the queue until reaching the index
				i = i.getNext();
				counter++;
			}
			return i.getData();//returns index data
			*/
		}
		
		//getter methods for private variables in Generic List
		public int getLength() {
			return length;
		}
		
		public Node<T> getHead() {
			return head;
		}
		
		//setter methods for private variables in Generic List
		public void setLength(int length) {
			this.length = length;
		}
		
		public void setHead(Node<T> head) {
			//Node<T> res = new Node<T>(head);
			this.head = head;
		}
		
		//function that stores and returns all values currently in the list as an ArrayList
		public ArrayList<T> dumpList(){
			ArrayList<T> lst = new ArrayList<T>();//declares new ArrayList to return
			/*Node<T> temp = this.head;//creates a node iterator to go through the list to print each element
			while(temp != null) {//while the iterator is not null
				lst.add(temp.getData());
				temp = temp.getNext();
			}*/
			for(T i : this) {//for each loop to loop through the list
				lst.add(i);//adds each element of the list to the ArrayList
			}
			return lst;
		}
		
		//function that is used to change the element of a node at a specified index.
		public T set(int index, T element) {
			if (this.length <= index) {//checks if the index is out of bounds
				return null;
			}
			T oldValue;
			int i = 0;
			Node<T> temp = this.head;//form of a iterator, used to change the value instead of an iterator
			while(i < index) {//for loop to get to the node that we want to change the value of
				temp = temp.getNext();
				i++;
			}
			oldValue = temp.getData();//stores the value of the old node's data to return
			temp.setData(element);//sets the data of the node to the element passed in as a parameter
			return oldValue;//returns previous value of the specified index.
		}
		
		//function that serves as an iterator over the elements if they were in reverse order
		public Iterator<T> descendingIterator(){
			/*ArrayList<T> lst = new ArrayList<T>();//declares ArrayList to put all of the elements into
			for(int i = this.length; i >= 0; i--) {//adds each element into arraylist in reverse order
				lst.add(this.get(i));
			}
			Iterator<T> res = lst.iterator();//creates an iterator that will traverse through this reversed version of the current list put into an arraylist
			return res;*/
			return new ReverseGLLIterator<T>(this);
		}
		
		
			
}

