import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deque<Item> implements Iterable<Item> {

	private static final String fileName = "E:\\TestInput\\Deque\\input_1.txt";

	private class Node {
		private Item item;
		private Node previous;
		private Node next;

		private Node(Item item) {
			this.item = item;
		}

	}

	private class DequeListIterator implements Iterator<Item> {

		private Node current;

		public DequeListIterator() {
			current = first;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Item next() {
			if (current != null) {
				Item item = current.item;
				current = current.next;
				return item;
			} else {
				throw new NoSuchElementException();
			}

		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	private Node first;
	private Node last;
	private int size;

	/**
	 * Create a new Deque Object
	 * 
	 */
	public Deque() {
		super();
	}

	/**
	 * is the deque empty?
	 * 
	 * @return true, if size is zero
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * return the number of items on the deque
	 * 
	 * @return String value of the size
	 */
	public int size() {
		return size;
	}

	/**
	 * add the item to the front
	 * 
	 * @param Generic
	 *            item to be added to the first
	 */
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node temp = new Node(item);
		if (first != null) {
			first.previous = temp;
			temp.next = first;
			temp.previous = null;
			first = temp;
		} else {
			first = temp;
			last = temp;
			first.previous = null;
			first.next = null;
		}
		size++;
	}

	/**
	 * add the item to the end
	 * 
	 * @param Generic
	 *            item to be added to the end
	 */
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node temp = new Node(item);
		if (last != null) {
			last.next = temp;
			temp.previous = last;
			last = temp;

		} else {
			last = temp;
			first = temp;
			last.previous = last.next = null;
		}
		size++;
	}

	/**
	 * remove and return the item from the front
	 * 
	 * @return Generic item to be first
	 */
	public Item removeFirst() {
		if (first != null) {
			Node temp = first;
			first = first.next;
			temp.next = null;
			if (size > 1) {

				first.previous = null;
			} else {
				first = null;
				last = null;
			}
			size--;
			return temp.item;
		} else
			throw new NoSuchElementException();
	}

	/**
	 * remove and return the item from the end
	 * 
	 * @return generic item to be last
	 */
	public Item removeLast() {
		if (last != null) {
			Node temp = last;
			last = last.previous;
			temp.previous = null;
			if (size > 1) {

				last.next = null;
			} else {
				first = null;
				last = null;
			}
			size--;
			return temp.item;
		} else {
			throw new NoSuchElementException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Item> iterator() {
		return new DequeListIterator();

	}

	public static void main(String[] args) throws FileNotFoundException {
		Deque<String> dq = new Deque<String>();
		Deque<String> dq1 = new Deque<String>();
		Scanner in = new Scanner(new File(fileName));
		in.useDelimiter(" |\\r\\n");
		while (in.hasNext()) {
			String operation = in.next();
			String position = in.next();
			String data = in.next();

			if (operation.equalsIgnoreCase(("A"))) {
				if (position.equalsIgnoreCase("F")) {
					dq.addFirst(data.trim());
				} else if (position.equalsIgnoreCase("L")) {
					dq1.addLast(data.trim());
				}
			} else if (operation.equalsIgnoreCase(("R"))) {
				if (position.equalsIgnoreCase("F")) {
					//System.out.println("Removed item:" + dq1.removeFirst());

				} else if (position.equalsIgnoreCase("L")) {
					//System.out.println("Removed item:" + dq.removeLast());

				}
			}

			//System.out.println(dq.isEmpty());
		}
		in.close();
		//System.out.println("dq");
		for (String temp : dq) {
			//System.out.println(temp);
		}
		//System.out.println("dq1");
		for (String temp : dq1) {
			//System.out.println(temp);
		}

	}

}
