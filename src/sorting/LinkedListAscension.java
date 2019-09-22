package sorting;

public class LinkedListAscension {
	public static void main(String[] args) {
		LinkedListAscension list = new LinkedListAscension();
		//adds a head, one before the head and one between
		list.enqueue(17);
		list.enqueue(3);
		list.enqueue(10);
		//tests with negative numbers
		list.enqueue(-10);
		list.enqueue(-12);
		list.enqueue(-11);
		//tests with numbers bigger than 127, limit for Integer comparissons
		list.enqueue(170);
		list.enqueue(173);
		list.enqueue(172);
	}
	Node head;
	public void enqueue(int i) {
		if (head == null) {
			head = new Node(i);
			head.next = head;
			head.prev = head;
		} else if (head.val > i) {
			addBefore(head, new Node(i));
			head = head.prev;
		} else {
			Node tmp = head;
			 do {
				tmp = tmp.next;
			}while(tmp != head && tmp.val < i);
			addBefore(tmp, new Node(i));
		}	
		print();
	}

	private void print() {
		Node tmp = head;
		if(head == null) {
			return;
		}
		do{
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}while(tmp!= head);
		System.out.println();
		
	}
	/**
	 * lägger till tmp framför node.
	 * */
	private void addBefore(Node node, Node tmp) {
		tmp.prev = node.prev;
		node.prev.next = tmp;
		tmp.next = node;
		node.prev = tmp;

	}

	private class Node {
		Node next;
		Node prev;
		int val;

		public Node(int i) {
			val = i;
		}
	}
}
