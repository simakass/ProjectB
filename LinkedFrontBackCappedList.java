public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
	private int capacity, numberOfEntries;

	public LinkedFrontBackCappedList(int size) {
		numberOfEntries = 0;
		capacity = size;
		head = new Node(null);
		tail = head;

		Node current = head;
		for (int i = 1; i < size; i++) {
			current.next = new Node(null);
			current = current.next;
		}
		
	}

	@Override
	public String toString() {
		String nodeString = "[";
		Node current = head;
		while (current != null) {
			if (current.data != null) {
				nodeString += current.data;
			}
			if (current.next != null && current.next.data != null) {
				nodeString += ", ";
			}
			current = current.next;
		}
		
		nodeString += "]";
		nodeString += "\tsize=" + numberOfEntries + "\tcapacity=" + capacity;

		if (!isEmpty()){
			nodeString += "\thead=" + head.data + " tail=" + tail.data;
		}
		return nodeString;
	}

	public boolean addFront(T newEntry) {

		if (isFull()){ //no room, return false
			return false;

		}	else if (isEmpty()){ //head.data == null
			head.data = newEntry;
			tail = head; //single entry, tail points to head
			numberOfEntries++;
			return true;

		} else {
			Node current = head;
			while (current.next.data != null){ //find the next null data
				current = current.next;
			}
			current.next = current.next.next; //skip the null data
			Node newFront = new Node (newEntry, head); //new node that points to previous head
			head = newFront; 
			numberOfEntries++;
			return true;
		}
		
		
		
	}

	public boolean addBack(T newEntry) {
		if (isFull()){
			return false;

		} else if (isEmpty()){
			head.data = newEntry;
			tail = head;
			numberOfEntries++;
			return true;

		} else {
			tail.next.data = newEntry;
			tail = tail.next;
			numberOfEntries++;
			return true;
		}
		
	}

	public T removeFront() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}else{
			Node current = head;
			return (T) current.next;
		}
	}

	public T removeBack() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clear() {
		if (!isEmpty()){
			Node current = head;
			while (current!=null){
				current.data = null;
				current = current.next;
			}
			numberOfEntries = 0;
			tail = head;
		}

	}

	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(T anEntry) {
		// TODO Auto-generated method stub
		int count = 0;
		if(!isEmpty()){
			Node current = head;
			if(current == anEntry){
				count++;
			}
			current = current.next;
		}
		return count;
	}

	public int lastIndexOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean contains(T anEntry) {
	// TODO Auto-generated method stub
		Node currentNode = head;
		while (currentNode != null)
		{
			if (currentNode.data == anEntry)
			{
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}


	public int size() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return head.data == null;
	}

	public boolean isFull() {
		return tail.next == null; // if no nodes after tail, list is full
	}

	public class Node {
		public T data;
		public Node next;

		private Node(T dataValue) {
			data = dataValue;
			next = null;
		}

		private Node(T dataValue, Node nextNode) {
			data = dataValue;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

}
