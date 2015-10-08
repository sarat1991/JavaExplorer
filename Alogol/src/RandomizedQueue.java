import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private static BigDecimal Loadfactor = new BigDecimal(0.75);
	private Item[] randque;
	private int size;
	private static final String fileName = "E:\\TestInput\\RandomizedQueue\\input_1.txt";

	private class RandomizedQueueList implements Iterator<Item> {

		private int count = 0;
		private Item randomItQue[];
		private int randIndex;

		public RandomizedQueueList() {
			randomItQue = (Item[]) new Object[size];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return count != size;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Item next() {
			if (count < size) {
				do {
					randIndex = StdRandom.uniform(0, size);
				} while (randomItQue[randIndex] != null);
				randomItQue[randIndex] = randque[randIndex];
				count++;
				return randque[randIndex];
			} else
				throw new NoSuchElementException();

		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	/**
	 * Constructor for creating randomized queue
	 */
	public RandomizedQueue() {
		randque = (Item[]) new Object[1];
	}

	/**
	 * is the queue empty?
	 * 
	 * @return true, if queue is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * return the number of items on the queue
	 * 
	 * @return integer value of the number of items
	 */
	public int size() {
		return size;
	}

	/**
	 * add the item
	 * 
	 * @param item
	 *            Generic item to be added
	 */
	public void enqueue(Item item) {

		if (item != null) {
			randque[size++] = item;
			BigDecimal elementOccupied = new BigDecimal(size/randque.length);			
			if ( elementOccupied.compareTo(Loadfactor)!=-1) {
				int newLength = randque.length;
				Item[] temp = (Item[]) new Object[newLength<<1];
				//System.out.println("newLength"+ newLength);
				for (int i = 0; i < size; i++) {
					temp[i] = randque[i];
				}
				randque = temp;
			}
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * remove and return a random item
	 * 
	 * @return Generic item
	 */
	public Item dequeue() {
		if (size != 0) {
			int index = StdRandom.uniform(0, size);
			Item returnItem = randque[index];
			randque[index] = randque[--size];
			randque[size] = null;
			BigDecimal elementOccupied = new BigDecimal((double)size/randque.length);
			//System.out.println(elementOccupied);
			if (elementOccupied.compareTo(new BigDecimal(1).subtract(Loadfactor))!=1) {
				int newLength = randque.length;
				//System.out.println("newLength: "+newLength);
				newLength = newLength>>1;
				Item[] temp = (Item[]) new Object[newLength>>1];
				//System.out.println("newLength: "+ newLength);
				for (int i = 0; i < size; i++) {
					temp[i] = randque[i];
				}

			}

			return returnItem;
		} else
			throw new NoSuchElementException();
	}

	/**
	 * return (but do not remove) a random item
	 * 
	 * @return generic item
	 */
	public Item sample() {
		if(size==0) throw new NoSuchElementException(); 
		int index = (Integer) StdRandom.uniform(size);
		return randque[index];
	}

	@Override
	public Iterator<Item> iterator() {

		return new RandomizedQueueList();
	}

	public static void main(String[] args) throws FileNotFoundException {
		RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();
		Scanner in = new Scanner(new File(fileName));

		in.useDelimiter(" |\\r\\n");
		while (in.hasNext()) {
			String operation = in.next();

			if (operation.equalsIgnoreCase(("E"))) {
				String data = in.next();
				dq.enqueue(Integer.parseInt(data));

			} else if (operation.equalsIgnoreCase(("D"))) {
				//System.out.println(dq.dequeue());
			}
			//System.out.println("Size: "+ dq.size());

		}
		in.close();
		
//		System.out.println("Iterator1");
//		for (Integer temp : dq) {
//			for (Integer test : dq) {
//				System.out.println("" + test);
//				System.out.println(temp);
//			}
//
//		}
//		System.out.println("Iterator2");
//		for (Integer temp : dq) {
//			System.out.println("" + temp);
//		}

		
	}

}
