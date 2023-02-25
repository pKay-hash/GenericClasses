import java.util.ArrayList;
import java.util.Iterator;

//Used to implement the Iterator interface to iterate through MyHashMap
	class HMIterator<T> implements Iterator<T> {
		ArrayList<GenericQueue<T>> list;
		GenericList<T>.Node<T> curr;//the node in front of the current node.
		int index;//keeps track of the generic queue that we are on
		
		//constructor
		public HMIterator(MyHashMap<T> map) {
			if (map.isEmpty()) {//if the map is empty, return immediately
				return;
			}
			this.list = map.map;//stores the ArrayList of Generic Queues
			for(int i = 0; i < list.size(); i++) {//go through arrayList of Generic Queues
				if (list.get(i) != null && list.get(i).getLength() > 0) {//checks if there is anything in the current Generic Queue
					this.curr = list.get(i).getHead();//gets the first thing in the queue if it isn't empty
					this.index = i;//sets index to the number Generic Queue that we are at
					return;//returns and doesn't continue
				}
			}
			return;
		}
		
		@Override
		public boolean hasNext() {
			if(curr != null){//checks if next element exists
				return true;
			}
			if(index != 9) {//if there is no next element in the current queue, check if this is the last queue
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			/*if(curr.getNext() == null) {
				if(Math.abs(curr.getCode()%10) < 10)
					curr = curr.getCode();
			}*/
			T data = curr.getData();//saves the data of the next item
			//finds the next element in the list
			if(curr.getNext() != null)//checks if the current node is the last element in the current queue
				curr = curr.getNext();//increments the iterator
			else {
					for(int i = index+1; i < 10; i++) {//go through rest of the arrayList of Generic Queues
						if (list.get(i) != null && list.get(i).getLength() > 0) {//checks if there is anything in the current Generic Queue
							this.curr = list.get(i).getHead();//gets the first thing in the queue if it isn't empty
							this.index = i;//sets index to the number Generic Queue that we are at
							return data;//returns and doesn't continue
						}
					}
					index = 9;
					this.curr = null;
				}
			return data;
		}
	}