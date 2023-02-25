import java.util.Iterator;

//Used to implement the Iterator interface to iterate through our Generic List (In reverse order)
	class ReverseGLLIterator<T> implements Iterator<T> {
		GenericList<T>.Node<T> curr;//the node behind of the current node.
		GenericList<T>.Node<T> head;//head of the list
		//constructor
		public ReverseGLLIterator(GenericList<T> list) {
			head = list.getHead();//sets head to list
			curr = list.getHead();//starts at the head of the list
			while (curr.getNext() != null) {//goes to the end of the list (tail)
				curr = curr.getNext();
			}
			//curr is at the tail
		}
		
		@Override
		public boolean hasNext() {//checks if there is an element before
			if(curr != null){//if curr is null from reaching the head previously, return false
				return true;
			}
			return false;
		}

		@Override
		public T next() {//goes to the previous element
			T data = curr.getData();//saves the data of the next item
			if(curr == head) {//if we are at the front of the list
				curr = null;//makes it so that hasNext() return false from now on
				return data;//return data without incrementing
			}
			GenericList<T>.Node<T> temp = head;//creates a node that iterates from the beginning of the list
			while(temp.getNext() != curr) {//goes until the node's next element is the current element
				temp = temp.getNext();//iterates the temp iterator
			}
			curr = temp;//sets curr equal to the node before itself
			return data;//return the element of the node that you went to
		}
	}