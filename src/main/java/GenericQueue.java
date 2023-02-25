

public class GenericQueue<T> extends GenericList<T>{
	public Node<T> tail;//traditional reference to the tail of the list
	
	//constructors
	public GenericQueue(T element) {
		Node<T> head = new Node<T>(element);//creates a node holding the element provided through the parameter
		this.setHead(head);//sets the new node as the head of the queue
		tail = head;//sets the tail to the head, considering there is only one element in the queue at this point
		setLength(1);//updates the length of the queue/list.
	}
	
	//constructor used to add an element with a hashCode
		public GenericQueue(T element, int code) {
			Node<T> head = new Node<T>(element);//creates a node holding the element provided through the parameter
			head.setCode(code);
			this.setHead(head);//sets the new node as the head of the queue
			tail = head;//sets the tail to the head, considering there is only one element in the queue at this point
			setLength(1);//updates the length of the queue/list.
		}
	
	//function that adds an element to the queue
	@Override
	public void add(T data) {
		Node<T> next = new Node<T>(data);//Makes the data passed in into type node
		if(getLength() == 0) {//checks if there is anything else in the list at first, if not, treat as first item in the list
			this.setHead(next);
			tail = next;
		}
		else {//if there were items previously in the list, add to the tail
			tail.setNext(next);//adds on to the end of the list using tail pointer
			tail = tail.getNext();//increments tail pointer to new end of list
			tail.setNext(null);
		}
		setLength(getLength()+1);//updates length of the queue
	}
	
	//function that adds element to the queue (but also has hashCode option, used in myHashMap)
	public void add(T data, int code) {
		Node<T> next = new Node<T>(data);//Makes the data passed in into type node
		next.setCode(code);
		if(getLength() == 0) {//checks if there is anything else in the list at first, if not, treat as first item in the list
			this.setHead(next);
			tail = next;
		}
		else {//if there were items previously in the list, add to the tail
			tail.setNext(next);//adds on to the end of the list using tail pointer
			tail = tail.getNext();//increments tail pointer to new end of list
			tail.setNext(null);
		}
		setLength(getLength()+1);//updates length of the queue
	}

	//function to delete the first element of the queue
	@Override
	public T delete() {
		if(getLength() == 0) {//makes sure there is something to delete in the list, if there isn't nothing happens.
			//System.out.println("There's nothing in the list to delete!");
			return null;
		}
		Node<T> res = this.getHead();//saves the current head of the list
		setHead(getHead().getNext());//sets the new head as the second item in the list
		setLength(getLength()-1);
		return res.getData();//returns the value of the old head of the list
	}
	
	//function that calls add() from above to enqueue an element to the queue
	public void enqueue(T data) {
		this.add(data);//calls the add function inherited as a abstract method from GenericList
	}
	
	//function that calls add() from above to enqueue an element to the queue (with hashCode parameter)
	public void enqueue(T data, int code) {
		this.add(data, code);//calls the add function inherited as a abstract method from GenericList
	}
	
	//function that calls delete() from above to dequeue an element from the queue
	public T dequeue() {
		return this.delete();//calls the delete function inheritied as an abstract method from GenericList
	}
	
	//checks to see if there is a specific node in the queue using its hashCode
	public boolean contains(int code) {
		Node<T> temp = this.getHead();//starts at head
		while(temp != null) {//goes until the end of the list
			if(temp.getCode() == code)//checks each code to see if it matches the code passed in
				return true;//returns true if so
			temp = temp.getNext();//iterates if not
		}
		return false;//returns false if it gets to the end of the list without finding the code
	}
}