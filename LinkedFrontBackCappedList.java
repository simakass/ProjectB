/* group names: <add your name>, Sima Kassianik, Christian Kurt Balais, Kevin Wong
 * filename: LinkedFrontBackCappedList.java
 * date: 3/29/2022
 * desc: Class implementation of FrontBackCappedListInterface<T> utilizing linked nodes.
 */

public class LinkedFrontBackCappedList<T extends Comparable<? super T>> 
   implements FrontBackCappedListInterface<T>,  
   Comparable<LinkedFrontBackCappedList<T>> {

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

		if (!isEmpty()) {
			nodeString += "\thead=" + head.data + " tail=" + tail.data;
		}
		return nodeString;
	}

	public boolean addFront(T newEntry) {

		if (isFull()) { // no room, return false
			return false;

		} else if (isEmpty()) { // head.data == null
			head.data = newEntry;
			tail = head; // single entry, tail points to head
			numberOfEntries++;
			return true;

		} else {
			Node current = head;
			while (current.next.data != null) { // find the next null data
				current = current.next;
			}
			current.next = current.next.next; // skip the null data
			Node newFront = new Node(newEntry, head); // new node that points to previous head
			head = newFront;
			numberOfEntries++;
			return true;
		}

	}

	public boolean addBack(T newEntry) {
		if (isFull()) {
			return false;

		} else if (isEmpty()) {
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
		if (isEmpty()) {
			return null;
		} else {
			T data = head.data;
			head = head.next;
			numberOfEntries--;
			return data;
		}
	}

	public T removeBack() {
		Node current = head;
		T data = null;

		if (!isEmpty()) {
			while (current != null && current.next != null) {
				if (current.next.next == null) {
					data = current.next.data;
					current.next = null;
					tail = current;
					numberOfEntries--;
					break;
				}
				current = current.next;
			}
		}
		return data;
	}

	public void clear() {
		if (!isEmpty()) {
			Node current = head;
			while (current != null) {
				current.data = null;
				current = current.next;
			}
			numberOfEntries = 0;
			tail = head;
		}

	}

	public T getEntry(int givenPosition) {
		Node current = head;

		if (isEmpty() || givenPosition < 0 || givenPosition > capacity) {
			return null;
		} else {
			for (int i = 0; i < capacity; i++) {
				if (i == givenPosition) {
					return current.data;
				}
				current = current.next;
			}
		}
		return null;
	}

	public int indexOf(T anEntry) {
		if (!isEmpty()) {
			int index = 0;
			Node current = head;

			while (current != null) {
				if (current.data.equals(anEntry)) {
					return index;
				}
				index++;
				current = current.next;
			}
		}
		return -1;
	}

	public int lastIndexOf(T anEntry) {
		Node current = head;
		LinkedFrontBackCappedList<T> reversedList = new LinkedFrontBackCappedList<T>(numberOfEntries);

		for (int i = 0; i < numberOfEntries; i++) {
			reversedList.addFront(current.data);
			current = current.next;
		}

		Node reversedCurrent = reversedList.head;

		for (int j = (numberOfEntries - 1); j >= 0; j--) {
			if (reversedCurrent.data.equals(anEntry)) {
				return j;
			}
			reversedCurrent = reversedCurrent.next;
		}
		return -1;
	}

	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.data.equals(anEntry)) {
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
	
	// EXTRA CREDIT
	@Override
	public int compareTo(LinkedFrontBackCappedList<T> other)
	{
		if (this.isEmpty() && other.isEmpty())
		{
			return 0; // same sizes, chains equal
		}
		if (this.numberOfEntries == other.numberOfEntries) // same sizes
		{
			for (int i=0; i<numberOfEntries; i++)
			{
				if (this.getEntry(i).compareTo(other.getEntry(i)) > 0)
				{
					return 1;
				}
				else if (this.getEntry(i).compareTo(other.getEntry(i)) < 0)
				{
					return -1;
				}
			}
			return 0;
		}
		else if (this.numberOfEntries > other.numberOfEntries)
		{
			for (int i=0; i<other.numberOfEntries; i++)
			{
				if (this.getEntry(i).compareTo(other.getEntry(i)) > 0)
				{
					return 1;
				}
				else if (this.getEntry(i).compareTo(other.getEntry(i)) < 0)
				{
					return -1;
				}
			}
			return 1;
		}
		else 
		{
			for (int i=0; i<numberOfEntries; i++)
			{
				if (this.getEntry(i).compareTo(other.getEntry(i)) > 0)
				{
					return 1;
				}
				else if (this.getEntry(i).compareTo(other.getEntry(i)) < 0)
				{
					return -1;
				}
			}
			return -1;
		}
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
