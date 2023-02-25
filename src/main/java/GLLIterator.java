import java.util.Iterator;

//Used to implement the Iterator interface to iterate through our Generic List
	class GLLIterator<T> implements Iterator<T> {
		GenericList<T>.Node<T> curr;//the node in front of the current node.
		
		//constructor
		public GLLIterator(GenericList<T> list) {
			curr = list.getHead();//starts at the head of the list
		}
		
		@Override
		public boolean hasNext() {
			if(curr != null){//checks if next element exists
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			T data = curr.getData();//saves the data of the next item
			curr = curr.getNext();//increments the iterator
			return data;//return the element of the node that you went to
		}
	}