public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
	private int numberOfNodes;

	public LinkedFrontBackCappedList(int size) {
		numberOfNodes = size;
		head = new Node(null);

		Node current = head;
		for (int i = 1; i<size;i++){
			current.next = new Node(null);
			current = current.next;
		}
		tail = current;
    }

	public String toString(){
		String nodeString = "[";
        Node current = head;
        while(current.next != null){
            nodeString += current.data;
            if(current.next != null){
                nodeString += ", ";
            }
            current = current.next;
        }
        nodeString += current.data;
		nodeString += "]";
        return nodeString;
	}

   
   
	public boolean addFront(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}



	
	public boolean addBack(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}



	
	public T removeFront() {
		// TODO Auto-generated method stub
		return null;
	}



	
	public T removeBack() {
		// TODO Auto-generated method stub
		return null;
	}



	
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}



	
	public int indexOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}



	
	public int lastIndexOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}



	
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}



	
	public int size() {
		return numberOfNodes;
	}



	
	public boolean isEmpty() {
		return head.data == null;
	}



	
	public boolean isFull() {
		return tail.data != null ;
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
