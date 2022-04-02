/* group names: <add your name>, Sima Kassianik, Christian Kurt Balais, Kevin Wong
 * filename: LinkedFrontBackCappedList.java
 * date: 4/02/2022
 * desc: Class implementation of FrontBackCappedListInterface<T> utilizing linked nodes.
 */

public class LinkedFrontBackCappedList<T extends Comparable<? super T>>
		implements FrontBackCappedListInterface<T>, Comparable<LinkedFrontBackCappedList<T>> {

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
		if (isFull()) {
			return false;

		} else if (isEmpty()) {
			head.data = newEntry;
			tail = head;
			numberOfEntries++;
			return true;

		} else if (!isEmpty()) {
			Node newHead = new Node(newEntry, head);
			head = newHead;
			numberOfEntries++;
			return true;
		}
		return false;
	}

	public boolean addBack(T newEntry) {
		if (isFull()) {
			return false;

		} else if (isEmpty()) {
			Node newNode = new Node(newEntry);
			head = newNode;
			tail = head;
			numberOfEntries++;
			return true;
		} else {
			Node newNode = new Node(newEntry);
			tail.setNextNode(newNode);
			tail = newNode;
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
			for (int i = 0; i < (numberOfEntries - 2); i++) {
				current = current.next;
			}
			data = tail.data;
			tail = current;
			tail.next = null;
			numberOfEntries--;
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
			for (int i = 0; i < numberOfEntries; i++) {
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

			for (int i = 0; i < numberOfEntries; i++) {
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
		Node current = head;

		for (int i = 0; i < numberOfEntries; i++) {
			if (current.data.equals(anEntry)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public int size() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public boolean isFull() {
		return numberOfEntries == capacity;
	}

	// EXTRA CREDIT
	@Override
	public int compareTo(LinkedFrontBackCappedList<T> other) {
		if (this.isEmpty() && other.isEmpty()) {
			return 0; // same sizes, chains equal
		}
		if (this.numberOfEntries == other.numberOfEntries) // same sizes
		{
			for (int i = 0; i < numberOfEntries; i++) {
				if (this.getEntry(i).compareTo(other.getEntry(i)) > 0) {
					return 1;
				} else if (this.getEntry(i).compareTo(other.getEntry(i)) < 0) {
					return -1;
				}
			}
			return 0;
		} else if (this.numberOfEntries > other.numberOfEntries) {
			for (int i = 0; i < other.numberOfEntries; i++) {
				if (this.getEntry(i).compareTo(other.getEntry(i)) > 0) {
					return 1;
				} else if (this.getEntry(i).compareTo(other.getEntry(i)) < 0) {
					return -1;
				}
			}
			return 1;
		} else {
			for (int i = 0; i < numberOfEntries; i++) {
				if (this.getEntry(i).compareTo(other.getEntry(i)) > 0) {
					return 1;
				} else if (this.getEntry(i).compareTo(other.getEntry(i)) < 0) {
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
